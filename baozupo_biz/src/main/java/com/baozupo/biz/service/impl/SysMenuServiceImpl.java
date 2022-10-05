package com.baozupo.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baozupo.base.enums.APIRquest;
import com.baozupo.base.enums.SysStatus;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.global.SQLConf;
import com.baozupo.biz.global.SysConstant;
import com.baozupo.biz.mapper.SysMenuMapper;
import com.baozupo.biz.service.SysMenuService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysMenu;
import com.baozupo.common.domain.vo.sys.SysMenuVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    SysMenuService sysMenuService;

    @Resource
    SysMenuMapper sysMenuMapper;

    @Override
    public IPage<SysMenu> getExpandPageList(SysMenuVO sysMenuVO) {
        // 一级菜单
        QueryWrapper<SysMenu> oneceWrapper = new QueryWrapper<>();
        oneceWrapper.eq(SQLConf.MENU_LEVEL, SysConstant.LEVEL_ONE);
        oneceWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        oneceWrapper.orderByDesc(SQLConf.SORT);

        Page<SysMenu> page = new Page<>();
        page.setCurrent(sysMenuVO.getCurrentPage());
        page.setSize(sysMenuVO.getPageSize());

        IPage<SysMenu> pageList = sysMenuService.page(page, oneceWrapper);
        List<SysMenu> list = pageList.getRecords();

        List ids = new ArrayList();
        list.forEach(item -> {
            if(item.getId() > 0 ){
                ids.add(item.getId());
            }
        });

        //二级菜单
        QueryWrapper<SysMenu> secondWrapper = new QueryWrapper<>();
        secondWrapper.in(SQLConf.PARENT_UID, ids);
        secondWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        List<SysMenu> secondList = sysMenuService.list(secondWrapper);

        List<Long> secondIds = new ArrayList<>();
        secondList.forEach(item -> {
            if(item.getId() > 0 ){
                secondIds.add(item.getId());
            }
        });
        // 三级菜单
        QueryWrapper<SysMenu> thirdWrapper = new QueryWrapper<>();
        thirdWrapper.in(SQLConf.PARENT_UID, secondIds);
        thirdWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        List<SysMenu> thirdList = sysMenuService.list(thirdWrapper);

        //将三级菜单列表导入二级菜单中
        secondList.forEach(parentItem -> {
            List<SysMenu> tempList = new ArrayList<>();
            for(SysMenu childItem : thirdList){
                if (childItem.getPid() == parentItem.getId()) {
                    tempList.add(childItem);
                }
            }
            tempList.sort((a,b) -> Integer.compare(b.getSort(),a.getSort()));
            parentItem.setChildMenuList(tempList);
        });

        // 将二级菜单列表导入一级菜单中
        for(SysMenu parentItem : list){
            List<SysMenu> tempList = new ArrayList<>();

            for (SysMenu item : secondList) {
                if (item.getPid() == parentItem.getId()) {
                    tempList.add(item);
                }
            }
            tempList.sort((a,b) -> Integer.compare(b.getSort(),a.getSort()));
            parentItem.setChildMenuList(tempList);
        }

        return pageList;
    }

    @Override
    public CommonResult addMenu(SysMenuVO sysMenuVO) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.MENU_NAME, sysMenuVO.getMenuName());
        SysMenu checkOne = sysMenuMapper.selectOne(queryWrapper);

        if(checkOne == null){
            SysMenu sysMenu = new SysMenu();
            sysMenu.setId(sysMenuVO.getId());
            sysMenu.setMenuName(sysMenuVO.getMenuName());
            sysMenu.setPid(sysMenuVO.getParentUid());
            sysMenu.setMenuLevel(sysMenuVO.getMenuLevel());
            sysMenu.setMenuType(sysMenuVO.getMenuType());
            sysMenu.setIcon(sysMenuVO.getIcon());
            sysMenu.setIntroduce(sysMenuVO.getIntroduce());
            sysMenu.setUrl(sysMenuVO.getUrl());

            int insert = sysMenuMapper.insert(sysMenu);
            if(insert > 0){
                return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.INSERT_SUCCESS, null);
            }
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.INSERT_FAIL, null);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.ENTITY_EXIST, null);
    }

    @Override
    public CommonResult getAllMenu() {
        // 一级菜单
        QueryWrapper<SysMenu> oneceWrapper = new QueryWrapper<>();
        oneceWrapper.eq(SQLConf.MENU_LEVEL, SysConstant.LEVEL_ONE);
        oneceWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        oneceWrapper.orderByDesc(SQLConf.SORT);


        List<SysMenu> list = sysMenuService.list(oneceWrapper);

        List ids = new ArrayList();
        list.forEach(item -> {
            if(item.getId() > 0 ){
                ids.add(item.getId());
            }
        });

        //二级菜单
        QueryWrapper<SysMenu> secondWrapper = new QueryWrapper<>();
        secondWrapper.in(SQLConf.PARENT_UID, ids);
        secondWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        List<SysMenu> secondList = sysMenuService.list(secondWrapper);

        List<Long> secondIds = new ArrayList<>();
        secondList.forEach(item -> {
            if(item.getId() > 0){
                secondIds.add(item.getId());
            }
        });
        // 三级菜单
        QueryWrapper<SysMenu> thirdWrapper = new QueryWrapper<>();
        thirdWrapper.in(SQLConf.PARENT_UID, secondIds);
        thirdWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        List<SysMenu> thirdList = sysMenuService.list(thirdWrapper);

        //将三级菜单列表导入二级菜单中
        secondList.forEach(parentItem -> {
            List<SysMenu> tempList = new ArrayList<>();
            for(SysMenu childItem : thirdList){
                if (childItem.getPid() == parentItem.getId()) {
                    tempList.add(childItem);
                }
            }
            tempList.sort((a,b) -> Integer.compare(b.getSort(),a.getSort()));
            parentItem.setChildMenuList(tempList);
        });

        // 将二级菜单列表导入一级菜单中
        for(SysMenu parentItem : list){
            List<SysMenu> tempList = new ArrayList<>();

            for (SysMenu item : secondList) {
                if (item.getPid() == parentItem.getId()) {
                    tempList.add(item);
                }
            }
            tempList.sort((a,b) -> Integer.compare(b.getSort(),a.getSort()));
            parentItem.setChildMenuList(tempList);
        }

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, list);
    }

    @Override
    public CommonResult updateMenu(SysMenuVO sysMenuVO) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ID, sysMenuVO.getId());
        SysMenu checkOne = sysMenuMapper.selectOne(queryWrapper);

        if(checkOne != null){
            SysMenu menu = new SysMenu();
            menu.setId(sysMenuVO.getId());
            menu.setMenuName(sysMenuVO.getMenuName());
            menu.setPid(sysMenuVO.getParentUid());
            menu.setMenuLevel(sysMenuVO.getMenuLevel());
            menu.setMenuType(sysMenuVO.getMenuType());
            menu.setIcon(sysMenuVO.getIcon());
            menu.setIntroduce(sysMenuVO.getIntroduce());
            menu.setUrl(sysMenuVO.getUrl());
            int update = sysMenuMapper.updateById(menu);
            if(update > 0){
                return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, null);
            }
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.OPERATION_FAIL, null);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.QUERY_NOT_FONUD, null);
    }

    @Override
    public CommonResult getMenuById(Long id) {
        SysMenu menu = sysMenuMapper.getMenuById(id);

        SysMenuVO sysMenuVO = new SysMenuVO();
        sysMenuVO.setId(menu.getId());
        sysMenuVO.setMenuName(menu.getMenuName());
        sysMenuVO.setMenuLevel(menu.getMenuLevel());
        sysMenuVO.setMenuType(menu.getMenuType());
        sysMenuVO.setParentUid(menu.getPid());
        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysMenuVO);
    }

    @Override
    public CommonResult deleteMenu(SysMenuVO sysMenuVO) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ID, sysMenuVO.getId());
        SysMenu checkOne = sysMenuMapper.selectOne(queryWrapper);

        if(checkOne == null){
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.QUERY_NOT_FONUD, null);
        }

        int delete = sysMenuMapper.deleteById(sysMenuVO.getId());
        if(delete > 0){
            return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.DELETE_SUCCESS, delete);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.DELETE_FAIL, null);
    }
}

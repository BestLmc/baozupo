package com.baozupo.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baozupo.base.enums.SysStatus;
import com.baozupo.biz.global.SQLConf;
import com.baozupo.biz.mapper.SysDictItemMapper;
import com.baozupo.biz.service.SysDictItemService;
import com.baozupo.biz.service.SysDictService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysDict;
import com.baozupo.common.domain.entity.sys.SysDictItem;
import com.baozupo.common.domain.vo.sys.SysDictItemVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典数据项表 服务实现类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements SysDictItemService {

    @Resource
    SysDictService sysDictService;

    @Autowired
    SysDictItemService sysDictItemService;

    @Resource
    SysDictItemMapper sysDictItemMapper;

    @Override
    public IPage<SysDictItem> getPageList(SysDictItemVO sysDictItemVO) {
        QueryWrapper<SysDictItem> queryWrapper = new QueryWrapper<>();

        // 父字典UID
        if (sysDictItemVO.getDictId() > 0 && sysDictItemVO.getDictId() > 0) {
            queryWrapper.like(SQLConf.DICT_ID, sysDictItemVO.getDictId());
        }

        // 字典名称
        if (StringUtils.isNotEmpty(sysDictItemVO.getItemLabel()) && !StringUtils.isEmpty(sysDictItemVO.getItemLabel().trim())) {
            queryWrapper.like(SQLConf.DICT_ITEM_LABEL, sysDictItemVO.getItemLabel().trim());
        }

        // 字典代码
        if (StringUtils.isNotEmpty(sysDictItemVO.getItemValue()) && !StringUtils.isEmpty(sysDictItemVO.getItemValue().trim())) {
            queryWrapper.like(SQLConf.DICT_ITEM_VALUE, sysDictItemVO.getItemValue().trim());
        }

        Page<SysDictItem> page = new Page<>();
        page.setCurrent(sysDictItemVO.getCurrentPage());
        page.setSize(sysDictItemVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.SORT, SQLConf.CREATE_TIME);
        IPage<SysDictItem> pageList = sysDictItemService.page(page, queryWrapper);
        return pageList;
    }

    @Override
    public List<SysDictItem> getList(SysDictItemVO sysDictItemVO) {
        // 查询字典
        QueryWrapper<SysDict> dictWrapper = new QueryWrapper<>();
        // 父字典代码
        if (StringUtils.isNotEmpty(sysDictItemVO.getDictCode()) && !StringUtils.isEmpty(sysDictItemVO.getDictCode().trim())) {
            dictWrapper.like(SQLConf.DICT_CODE, sysDictItemVO.getDictCode().trim());
        }
        dictWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        SysDict dict = sysDictService.getOne(dictWrapper);
        sysDictItemVO.setDictId(dict.getId());

        // 查询字典项
        QueryWrapper<SysDictItem> queryWrapper = new QueryWrapper<>();

        // 父菜单UID
        if (sysDictItemVO.getDictId() > 0 && sysDictItemVO.getDictId() > 0) {
            queryWrapper.like(SQLConf.DICT_ID, sysDictItemVO.getDictId());
        }

        // 字典名称
        if (StringUtils.isNotEmpty(sysDictItemVO.getItemLabel()) && !StringUtils.isEmpty(sysDictItemVO.getItemLabel().trim())) {
            queryWrapper.like(SQLConf.DICT_ITEM_LABEL, sysDictItemVO.getItemLabel().trim());
        }

        // 字典键值
        if (StringUtils.isNotEmpty(sysDictItemVO.getItemValue()) && !StringUtils.isEmpty(sysDictItemVO.getItemValue().trim())) {
            queryWrapper.like(SQLConf.DICT_ITEM_VALUE, sysDictItemVO.getItemValue().trim());
        }

        queryWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.SORT, SQLConf.CREATE_TIME);
        List<SysDictItem> dictItemList = sysDictItemService.list(queryWrapper);
        return dictItemList;
    }

    @Override
    public CommonResult add(SysDictItemVO sysDictItemVO) {
        return null;
    }

    @Override
    public CommonResult update(SysDictItemVO sysDictItemVO) {
        return null;
    }

    @Override
    public CommonResult delete(SysDictItemVO sysDictItemVO) {
        return null;
    }
}

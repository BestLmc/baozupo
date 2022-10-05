package com.baozupo.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baozupo.base.enums.APIRquest;
import com.baozupo.base.enums.SysStatus;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.global.SQLConf;
import com.baozupo.biz.mapper.SysDictMapper;
import com.baozupo.biz.service.SysDictService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysDict;
import com.baozupo.common.domain.vo.sys.SysDictVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Autowired
    SysDictService sysDictService;

    @Resource
    SysDictMapper sysDictMapper;

    @Override
    public IPage<SysDict> getPageList(SysDictVO sysDictVO) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();

        // 字典名称
        if (StringUtils.isNotEmpty(sysDictVO.getDictName()) && !StringUtils.isEmpty(sysDictVO.getDictName().trim())) {
            queryWrapper.like(SQLConf.DICT_NAME, sysDictVO.getDictName().trim());
        }

        // 字典代码
        if (StringUtils.isNotEmpty(sysDictVO.getDictCode()) && !StringUtils.isEmpty(sysDictVO.getDictCode().trim())) {
            queryWrapper.like(SQLConf.DICT_CODE, sysDictVO.getDictCode().trim());
        }

        Page<SysDict> page = new Page<>();
        page.setCurrent(sysDictVO.getCurrentPage());
        page.setSize(sysDictVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, SysStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.SORT, SQLConf.CREATE_TIME);
        IPage<SysDict> pageList = sysDictService.page(page, queryWrapper);
        return pageList;
    }

    @Override
    public CommonResult addSysDict(SysDictVO sysDictVO) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.DICT_CODE,sysDictVO.getDictCode());
        queryWrapper.eq(SQLConf.STATUS,sysDictVO.getDictName());
        queryWrapper.last(" LIMIT 1 ");

        SysDict temp = sysDictService.getOne(queryWrapper);
        if(temp != null){
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.ENTITY_NOT_EXIST);
        }

        SysDict sysDict = new SysDict();
        sysDict.setDictCode(sysDictVO.getDictCode());
        sysDict.setDictName(sysDictVO.getDictName());
        sysDict.setRemark(sysDictVO.getRemark());
        sysDict.setSort(sysDictVO.getSort());
        sysDict.setCreateBy("admin");
        sysDict.setUpdateBy("admin");

        int insert = sysDictMapper.insert(sysDict);

        if(insert > 0){
            return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.INSERT_SUCCESS);
        }

        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.INSERT_FAIL);
    }

    @Override
    public CommonResult updateSysDict(SysDictVO sysDictVO) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.DICT_CODE,sysDictVO.getDictCode());
        queryWrapper.eq(SQLConf.STATUS,sysDictVO.getDictName());
        queryWrapper.last(" LIMIT 1 ");

        SysDict temp = sysDictService.getOne(queryWrapper);
        if(temp != null){
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.ENTITY_NOT_EXIST);
        }

        SysDict sysDict = new SysDict();
        sysDict.setDictCode(sysDictVO.getDictCode());
        sysDict.setDictName(sysDictVO.getDictName());
        sysDict.setRemark(sysDictVO.getRemark());
        sysDict.setSort(sysDictVO.getSort());
        sysDict.setId(sysDictVO.getId());
        sysDict.setUpdateBy("admin");

        int insert = sysDictMapper.updateById(sysDict);

        if(insert > 0){
            return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.UPDATE_SUCCESS);
        }

        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.UPDATE_FAIL);
    }

    @Override
    public CommonResult deleteSysDict(SysDictVO sysDictVO) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.DICT_CODE,sysDictVO.getDictCode());
        queryWrapper.eq(SQLConf.STATUS,sysDictVO.getDictName());
        queryWrapper.last(" LIMIT 1 ");

        SysDict temp = sysDictService.getOne(queryWrapper);
        if(temp != null){
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.ENTITY_NOT_EXIST);
        }

        int insert = sysDictMapper.deleteById(sysDictVO.getId());

        if(insert > 0){
            return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.DELETE_SUCCESS);
        }

        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.DELETE_FAIL);
    }
}

package com.baozupo.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysDict;
import com.baozupo.common.domain.vo.sys.SysDictVO;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
public interface SysDictService extends IService<SysDict> {

    /**
     * 获取字典列表
     *
     * @param sysDictVO
     * @return
     */
    public IPage<SysDict> getPageList(SysDictVO sysDictVO);

    /**
     * 获取字典列表
     *
     * @param sysDictVO
     * @return
     */
    public CommonResult addSysDict(SysDictVO sysDictVO);

    /**
     * 获取字典列表
     *
     * @param sysDictVO
     * @return
     */
    public CommonResult updateSysDict(SysDictVO sysDictVO);

    /**
     * 获取字典列表
     *
     * @param sysDictVO
     * @return
     */
    public CommonResult deleteSysDict(SysDictVO sysDictVO);
}

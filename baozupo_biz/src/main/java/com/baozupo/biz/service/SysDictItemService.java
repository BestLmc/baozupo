package com.baozupo.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysDictItem;
import com.baozupo.common.domain.vo.sys.SysDictItemVO;

import java.util.List;

/**
 * <p>
 * 字典数据项表 服务类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
public interface SysDictItemService extends IService<SysDictItem> {

    /**
     * 获取字典项列表
     *
     * @param sysDictItemVO
     * @return
     */
    public IPage<SysDictItem> getPageList(SysDictItemVO sysDictItemVO);

    /**
     * 获取字典项列表
     *
     * @param sysDictItemVO
     * @return
     */
    public List<SysDictItem> getList(SysDictItemVO sysDictItemVO);

    /**
     * 获取字典项列表
     *
     * @param sysDictItemVO
     * @return
     */
    public CommonResult add(SysDictItemVO sysDictItemVO);

    /**
     * 获取字典项列表
     *
     * @param sysDictItemVO
     * @return
     */
    public CommonResult update(SysDictItemVO sysDictItemVO);

    /**
     * 获取字典项列表
     *
     * @param sysDictItemVO
     * @return
     */
    public CommonResult delete(SysDictItemVO sysDictItemVO);
}

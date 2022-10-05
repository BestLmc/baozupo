package com.baozupo.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysUser;
import com.baozupo.common.domain.vo.sys.SysUserVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
public interface SysUserService extends IService<SysUser> {

    CommonResult getUser(SysUserVo userVo);

    public CommonResult addSysUser(SysUserVo sysUserVo);

    public CommonResult updateSysUser(SysUserVo sysUserVo);

    public CommonResult getSysUserById(String uid);

    public CommonResult deleteSysUser(SysUserVo sysUserVo);

}

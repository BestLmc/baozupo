package com.baozupo.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysRole;
import com.baozupo.common.domain.vo.sys.SysRoleVO;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
public interface SysRoleService extends IService<SysRole> {

    CommonResult addRole(SysRoleVO sysRoleVO);

    CommonResult updateRole(SysRoleVO sysRoleVO);

    CommonResult getRoleById(String uid);

    CommonResult deleteRole(SysRoleVO sysRoleVO);
}

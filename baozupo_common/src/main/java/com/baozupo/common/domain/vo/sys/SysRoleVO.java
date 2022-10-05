package com.baozupo.common.domain.vo.sys;


import com.baozupo.base.domain.BaseVO;
import lombok.Data;

@Data
public class SysRoleVO extends BaseVO<SysRoleVO> {

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色介绍
     */
    private String introduce;
}

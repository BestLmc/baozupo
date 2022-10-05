package com.baozupo.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baozupo.base.enums.APIRquest;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.global.SQLConf;
import com.baozupo.biz.mapper.SysRoleMapper;
import com.baozupo.biz.service.SysRoleService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysRole;
import com.baozupo.common.domain.vo.sys.SysRoleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    SysRoleMapper sysRoleMapper;
    @Override
    public CommonResult addRole(SysRoleVO sysRoleVO) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ROLE_NAME, sysRoleVO.getRoleName());
        SysRole checkOne = sysRoleMapper.selectOne(queryWrapper);

        if(checkOne == null){
            SysRole role = new SysRole();
            role.setIntroduce(sysRoleVO.getIntroduce());
            role.setRoleName(sysRoleVO.getRoleName());
            int insert = sysRoleMapper.insert(role);
            if(insert > 0){
                return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.INSERT_SUCCESS, null);
            }
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.INSERT_FAIL, null);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.QUERY_NOT_FONUD, null);
    }

    @Override
    public CommonResult updateRole(SysRoleVO sysRoleVO) {
        SysRole sysRole = new SysRole();
        sysRole.setId(sysRoleVO.getId());
        sysRole.setIntroduce(sysRoleVO.getIntroduce());
        sysRole.setRoleName(sysRoleVO.getRoleName());
        int update = sysRoleMapper.updateById(sysRole);
        if(update > 0){
            return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, null);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.OPERATION_FAIL, null);
    }

    @Override
    public CommonResult getRoleById(String uid) {
        SysRole sysRole = sysRoleMapper.selectById(uid);
        SysRoleVO sysRoleVO = new SysRoleVO();
        sysRoleVO.setId(sysRole.getId());
        sysRoleVO.setIntroduce(sysRole.getIntroduce());
        sysRoleVO.setRoleName(sysRole.getRoleName());
        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysRoleVO);
    }

    @Override
    public CommonResult deleteRole(SysRoleVO sysRoleVO) {
        int delete = sysRoleMapper.deleteById(sysRoleVO.getId());
        if(delete > 0){
            return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.DELETE_SUCCESS, delete);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.DELETE_FAIL, null);
    }
}

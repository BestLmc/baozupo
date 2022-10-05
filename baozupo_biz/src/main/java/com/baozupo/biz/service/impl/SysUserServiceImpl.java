package com.baozupo.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baozupo.base.enums.APIRquest;
import com.baozupo.base.enums.SysStatus;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.global.SQLConf;
import com.baozupo.biz.mapper.SysUserMapper;
import com.baozupo.biz.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysUser;
import com.baozupo.common.domain.vo.sys.SysUserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    SysUserService sysUserService;

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public CommonResult getUser(SysUserVo userVo) {
        SysUser sysUser = sysUserMapper.selectById(userVo.getId());
        SysUserVo returnUserVo = new SysUserVo();
        if(sysUser == null){
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.QUERY_NOT_FONUD, returnUserVo);
        } else {
            returnUserVo.setId(sysUser.getId());
            returnUserVo.setUserName(sysUser.getUsername());
            returnUserVo.setNickName(sysUser.getNickName());
            returnUserVo.setPassWord(sysUser.getPassword());
            returnUserVo.setComfirmPassword(sysUser.getPassword());
            returnUserVo.setGender(sysUser.getGender());
            returnUserVo.setBirthday(sysUser.getBirthday());
            returnUserVo.setEmail(sysUser.getEmail());
            returnUserVo.setMobile(sysUser.getPhone());
            returnUserVo.setIntroduce(sysUser.getIntroduce());
        }

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, returnUserVo);
    }

    @Override
    public CommonResult addSysUser(SysUserVo sysUserVo) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.USER_NAME, sysUserVo.getUserName());
        SysUser checkOne = sysUserMapper.selectOne(queryWrapper);

        if(checkOne == null){
            SysUser sysUser = new SysUser();
//        tAdmin.setUid(UUID.randomUUID().toString().replace("-",""));
            sysUser.setUsername(sysUserVo.getUserName());
            sysUser.setNickName(sysUserVo.getNickName());
            sysUser.setPassword(sysUserVo.getPassWord());
            sysUser.setGender(sysUserVo.getGender());
            sysUser.setEmail(sysUserVo.getEmail());
            sysUser.setPhone(sysUserVo.getMobile());
            sysUser.setIntroduce(sysUserVo.getIntroduce());
            sysUser.setBirthday(sysUserVo.getBirthday());

            int insert = sysUserMapper.insert(sysUser);
            if(insert > 0){
                return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.INSERT_SUCCESS, insert);
            }
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.INSERT_FAIL, null);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.INSERT_FAIL, null);
    }

    @Override
    public CommonResult updateSysUser(SysUserVo sysUserVo) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ID, sysUserVo.getId());
        SysUser checkOne = sysUserMapper.selectOne(queryWrapper);

        if(checkOne != null){
            SysUser sysUser = new SysUser();
            sysUser.setId(sysUserVo.getId());
            sysUser.setUsername(sysUserVo.getUserName());
            sysUser.setNickName(sysUserVo.getNickName());
            sysUser.setPassword(sysUserVo.getPassWord());
            sysUser.setGender(sysUserVo.getGender());
            sysUser.setEmail(sysUserVo.getEmail());
            sysUser.setPhone(sysUserVo.getMobile());
            sysUser.setIntroduce(sysUserVo.getIntroduce());
            sysUser.setBirthday(sysUserVo.getBirthday());

            int update = sysUserMapper.updateById(sysUser);
            if(update > 0){
                return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, update);
            }
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.OPERATION_FAIL, update);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.OPERATION_FAIL, null);
    }

    @Override
    public CommonResult getSysUserById(String uid) {
        SysUser sysUser = sysUserMapper.selectById(uid);
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setId(sysUser.getId());
        sysUserVo.setUserName(sysUser.getUsername());
        sysUserVo.setNickName(sysUser.getNickName());
        sysUserVo.setPassWord(sysUser.getPassword());
        sysUserVo.setComfirmPassword(sysUser.getPassword());
        sysUserVo.setGender(sysUser.getGender());
        sysUserVo.setBirthday(sysUser.getBirthday());
        sysUserVo.setEmail(sysUser.getEmail());
        sysUserVo.setMobile(sysUser.getPhone());
        sysUserVo.setIntroduce(sysUser.getIntroduce());

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysUserVo);
    }

    @Override
    public CommonResult deleteSysUser(SysUserVo sysUserVo) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ID, sysUserVo.getId());
        SysUser checkOne = sysUserMapper.selectOne(queryWrapper);

        if(checkOne == null){
            return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.QUERY_NOT_FONUD, null);
        }
        checkOne.setStatus(SysStatus.DISABLED);
        int update = sysUserMapper.updateById(checkOne);
        if(update > 0){
            return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.DELETE_SUCCESS, update);
        }
        return new CommonResult(APIRquest.REQUEST_FAILED, MessageConf.DELETE_FAIL, null);
    }
}

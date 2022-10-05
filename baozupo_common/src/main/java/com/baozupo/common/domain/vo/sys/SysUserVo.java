package com.baozupo.common.domain.vo.sys;

import com.baozupo.base.domain.BaseVO;
import com.baozupo.common.annotion.keyword.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class SysUserVo extends BaseVO<SysUserVo> {

    /**
     * 用户名
     */
    @Length(min=1, max=5, message="用户名长度有误")
    private String userName;

    /**
     * 密码
     */
    @NonNull
    private String passWord;

    /**
     * 确认密码
     */
    private String comfirmPassword;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别(1:男2:女)
     */
    private String gender;

    /**
     * 个人头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 出生年月日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    /**
     * 手机
     */
    private String mobile;


    /**
     * 自我简介最多150字
     */
    private String introduce;

    /**
     * 角色Uid
     */
    private String roleUid;

    public SysUserVo() {
    }
}

package com.baozupo.common.domain.vo.sys;

import com.baozupo.base.domain.BaseVO;
import lombok.Data;

@Data
public class SysMenuVO extends BaseVO<SysMenuVO> {

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单级别
     */
    private Boolean menuLevel;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 父uid
     */
    private Long parentUid;

    /**
     * url地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序字段，越大越靠前
     */
    private Integer sort;

    /**
     * 菜单类型 0: 菜单   1: 按钮
     */
    private Boolean menuType;
}

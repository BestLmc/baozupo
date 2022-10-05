package com.baozupo.common.domain.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysMenu对象", description="菜单表")
public class SysMenu implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "唯一uid")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "上级菜单ID")
    private Long pid;

    @ApiModelProperty(value = "子菜单数目")
    private Integer subCount;

    @ApiModelProperty(value = "菜单类型 0: 菜单   1: 按钮")
    private Boolean menuType;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单代码")
    private String menuCode;

    @ApiModelProperty(value = "菜单级别")
    private Boolean menuLevel;

    @ApiModelProperty(value = "简介")
    private String introduce;

    @ApiModelProperty(value = "url地址")
    private String url;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "排序字段，越大越靠前")
    private Integer sort;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否显示 1:是 0:否")
    private Boolean isShow;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @TableField(exist = false)
    private List<SysMenu> childMenuList;

}

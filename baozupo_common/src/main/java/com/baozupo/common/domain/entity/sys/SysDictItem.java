package com.baozupo.common.domain.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典数据项表
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDictItem对象", description="字典数据项表")
public class SysDictItem implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "sys_dict字典ID")
    private String dictId;

    @ApiModelProperty(value = "字典标签")
    private String itemLabel;

    @ApiModelProperty(value = "字典键值")
    private String itemValue;

    @ApiModelProperty(value = "创建人UID")
    private String createBy;

    @ApiModelProperty(value = "最后更新人UID")
    private String updateBy;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态(1:启用，0:停用)")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;


}

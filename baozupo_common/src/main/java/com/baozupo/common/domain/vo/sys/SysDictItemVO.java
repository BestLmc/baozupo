package com.baozupo.common.domain.vo.sys;

import com.baozupo.base.domain.BaseVO;
import lombok.Data;

@Data
public class SysDictItemVO extends BaseVO<SysDictItemVO> {

    /**
     * sys_dict字典ID
     */
    private Long dictId;

    /**
     * sys_dict字典代码
     */
    private String dictCode;

    /**
     * 字典标签
     */
    private String itemLabel;

    /**
     * 字典键值
     */
    private String itemValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序字段
     */
    private Integer sort;
}

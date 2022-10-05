package com.baozupo.common.domain.vo.sys;

import com.baozupo.base.domain.BaseVO;
import lombok.Data;

@Data
public class SysDictVO extends BaseVO<SysDictVO> {


    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典代码
     */
    private String dictCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序字段
     */
    private Integer sort;

}

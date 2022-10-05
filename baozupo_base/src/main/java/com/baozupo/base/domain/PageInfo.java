package com.baozupo.base.domain;

import lombok.Data;

/**
 * @Description: 分页基类
 * @Author bestlmc
 * @Date 2021/6/24 14:48
 */
@Data
public class PageInfo<T> {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 每页数据大小
     */
    private Long pageSize;
}

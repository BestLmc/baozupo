package com.baozupo.biz.domain.entity;

import com.baozupo.base.domain.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author bestlmc
 * @since 2021-06-22
 */
@Data
public class TestBeen extends BaseEntity<TestBeen> {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}

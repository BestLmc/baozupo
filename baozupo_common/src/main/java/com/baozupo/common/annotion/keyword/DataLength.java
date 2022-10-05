package com.baozupo.common.annotion.keyword;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 自定义的长度注解
 * @Author bestlmc
 * @Date 2022/3/20 16:45
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataLength {

    // 允许字符串的最小值
    int min();
    // 允许字符串的最大值
    int max();
    // 自定义的错误提示信息
    String message();
}

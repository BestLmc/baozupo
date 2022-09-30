package com.baozupo.admin.annotion;

import java.lang.annotation.*;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author bestlmc
 * @Date 2022/3/27 17:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String title() default "";//模块名称
    String describe() default "";//描述
}

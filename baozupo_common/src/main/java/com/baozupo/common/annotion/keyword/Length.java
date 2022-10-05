package com.baozupo.common.annotion.keyword;

//import com.bestlmc.lihuamao.commons.annotion.constraint.LengthValidator;

import java.lang.annotation.*;

/**
 * @Description: 自定义的长度注解
 * @Author bestlmc
 * @Date 2022/2/28 23:39
 */

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = LengthValidator.class)
public @interface Length {

    // 允许字符串的最小值
    long min() default 0;
    // 允许字符串的最大值
    long max() default 50;
    // 自定义的错误提示信息
    String message() default "value is too long!";

//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};

}

package com.baozupo.admin.annotion;



import com.baozupo.admin.annotion.validator.IsLeekValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author bestlmc
 * @Date 2022/3/29 17:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Documented
@Constraint(validatedBy = IsLeekValidator.class) // 指定我们自定义的校验类
public @interface IsLeek {

    /**
     * 是否强制校验
     *
     * @return 是否强制校验的boolean值
     */
    boolean required() default true;

    /**
     * 校验不通过时的报错信息
     *
     * @return 校验不通过时的报错信息
     */
    String message() default "此用户不是韭零后，无法开户！";

    /**
     * 将validator进行分类，不同的类group中会执行不同的validator操作
     *
     * @return validator的分类类型
     */
    Class<?>[] groups() default {};

    /**
     * 主要是针对bean，很少使用
     *
     * @return 负载
     */
    Class<? extends Payload>[] payload() default {};


}

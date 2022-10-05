package com.baozupo.common.annotion.constraint;

import com.baozupo.common.annotion.keyword.Length;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @Author bestlmc
 * @Date 2022/3/20 19:28
 */
public class LengthValidator implements ConstraintValidator<Length, String> {
    private long min;
    private long max;
    private String type;


    @Override
    public void initialize(Length constraintAnnotation) {
        System.out.println("ssssss");
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("ssssss");
        if (null == value || StringUtils.isBlank(value)) {
            return false;
        }
        return value.length() >= min && value.length() <= max;
    }
}

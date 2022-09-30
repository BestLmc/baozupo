package com.baozupo.admin.annotion.validator;

import com.baozupo.admin.annotion.IsLeek;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author bestlmc
 * @Date 2022/3/29 17:02
 */
public class IsLeekValidator implements ConstraintValidator<IsLeek, String> {

    // 是否强制校验
    private boolean required;

    @Override
    public void initialize(IsLeek constraintAnnotation) {
        System.out.println("我进来了>>>>>>");
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("我进来了");
        if (required) {
            // 名字以"新韭菜"开头的则校验通过
            return !StringUtils.isEmpty(name) && name.startsWith("新韭菜");
        }
        return false;
    }
}

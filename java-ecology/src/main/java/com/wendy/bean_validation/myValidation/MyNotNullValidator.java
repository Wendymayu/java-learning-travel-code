package com.wendy.bean_validation.myValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/8 22:28
 * @Version 1.0
 */
public class MyNotNullValidator implements ConstraintValidator<MyNotNull, Object> {
    @Override
    public void initialize(MyNotNull selfDefinedNotNull) {
        System.out.println("start init MyNotNull");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return false;
        }
        return true;
    }
}

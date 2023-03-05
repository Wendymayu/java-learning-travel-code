package com.wendy.bean_validation.myValidation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MyNotNullValidator.class})
public @interface MyNotNull {
    String message() default "对象不能为null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

package com.zz.yuan_user.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IsEmailValidator.class})
public @interface IsEmail {
    boolean required() default true;

    String message() default "not an email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

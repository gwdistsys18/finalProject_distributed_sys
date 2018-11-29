package com.zz.yuan_user.validator;

import com.zz.yuan_user.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//验证器
public class IsEmailValidator implements ConstraintValidator<IsEmail, String> {

    private boolean required = false;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (required){
            return ValidatorUtil.isEmail(s);
        }else {
            if (StringUtils.isEmpty(s)) return true;
            return ValidatorUtil.isEmail(s);
        }
    }

    @Override
    public void initialize(IsEmail constraintAnnotation) {
        required = constraintAnnotation.required();
    }
}

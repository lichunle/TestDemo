package com.example.demo.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String REGEX = "^(13|14|15|17|18)[0-9]{9}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            return value.matches(REGEX);
        }
        return true;
    }
}

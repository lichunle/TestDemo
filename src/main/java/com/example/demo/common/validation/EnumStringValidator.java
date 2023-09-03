package com.example.demo.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EnumStringValidator implements ConstraintValidator<EnumString, String> {

    private boolean ignoreNullOrEmpty;
    private Set<String> constStrings;
    @Override
    public void initialize(EnumString parameters) {
        this.ignoreNullOrEmpty = parameters.ignoreNullOrEmpty();
        Set<String> s = new HashSet<String>();
        for (String str : parameters.constStrings()) {
            if (null != str && str.length() > 0) {
                s.add(str);
            }
        }
        this.constStrings = Collections.unmodifiableSet(s);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return ignoreNullOrEmpty;
        } else {
            return constStrings.contains(value) || (0 == value.length() && ignoreNullOrEmpty);
        }
    }
}

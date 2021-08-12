package com.myproject.technicaltest.annotationImpl;

import com.myproject.technicaltest.annotation.CheckUsernameFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CheckUsernameValidator implements ConstraintValidator<CheckUsernameFormat, String> {


    @Override
    public void initialize(CheckUsernameFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if (object.matches("\\b[a-zA-Z][a-zA-Z0-9\\-._]{3,}\\b")) {
            return true;

        } else {
            return false;
        }
    }
}

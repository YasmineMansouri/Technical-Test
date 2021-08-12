package com.myproject.technicaltest.annotationImpl;

import com.myproject.technicaltest.annotation.CheckDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;


public class CheckDateValidator implements ConstraintValidator<com.myproject.technicaltest.annotation.CheckDateFormat, String> {


    @Override
    public void initialize(CheckDateFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        try {
            LocalDate.parse(object,
                    DateTimeFormatter.ofPattern("uuuu-M-d")
                            .withResolverStyle(ResolverStyle.STRICT)
            );

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
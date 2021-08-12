package com.myproject.technicaltest.annotationImpl;

import com.myproject.technicaltest.annotation.CheckResidenceCountry;
import com.myproject.technicaltest.utils.Constantes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckResidenceCountryValidator implements ConstraintValidator<CheckResidenceCountry, String> {


    @Override
    public void initialize(CheckResidenceCountry constraintAnnotation) {
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        try {
            return Constantes.COUNTRY_NAME.equalsIgnoreCase(object);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
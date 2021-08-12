package com.myproject.technicaltest.annotation;

import com.myproject.technicaltest.annotationImpl.CheckResidenceCountryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckResidenceCountryValidator.class)
@Documented
public @interface CheckResidenceCountry {

    String message() default "User must be a french resident";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
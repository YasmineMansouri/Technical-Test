package com.myproject.technicaltest.annotation;

import com.myproject.technicaltest.annotationImpl.CheckUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckUsernameValidator.class)
@Documented
public @interface CheckUsernameFormat {

    String message() default "The Username must have at least 3 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

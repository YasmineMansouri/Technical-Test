package com.myproject.technicaltest.annotation;

import com.myproject.technicaltest.annotationImpl.CheckDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * CheckDateFormat interface to help creating the annotation that check the date format.
 * @author Yasmine MANSOURI
 *
 */

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckDateValidator.class)
@Documented
public @interface CheckDateFormat {

    String message() default "Date format not valid try yyyy-MM-dd";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
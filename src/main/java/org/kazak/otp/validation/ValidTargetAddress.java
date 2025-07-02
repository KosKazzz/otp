package org.kazak.otp.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = ValidTargetAddressValidator.class)
public @interface ValidTargetAddress {

    String message() default "Некорректный адрес";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
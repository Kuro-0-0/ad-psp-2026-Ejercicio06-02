package com.salesianostriana.viviendafilter.validations;

import jakarta.validation.Constraint;

import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrecioLimiteValidator.class)
@Documented
public @interface PrecioLimite {

    int value() default 1000000;

    String message() default "precio fuera de rango";

    Class<?>[] groups() default {};

    Class<? extends jakarta.validation.Payload>[] payload() default {};

}

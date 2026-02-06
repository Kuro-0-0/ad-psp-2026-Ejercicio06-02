package com.salesianostriana.viviendafilter.validations;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MetrosCuadradosLimiteValidator.class)
public @interface MetrosCuadradosLimite {

    int value() default 1000;

    String message() default "metrosCuadrados fuera de rango";

    Class<?>[] groups() default {};

    Class<? extends jakarta.validation.Payload>[] payload() default {};

}

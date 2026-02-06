package com.salesianostriana.viviendafilter.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrecioLimiteValidator implements ConstraintValidator<PrecioLimite, Integer> {


    int max;

    @Override
    public void initialize(PrecioLimite constraintAnnotation) {
        max = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && integer <= max;
    }
}

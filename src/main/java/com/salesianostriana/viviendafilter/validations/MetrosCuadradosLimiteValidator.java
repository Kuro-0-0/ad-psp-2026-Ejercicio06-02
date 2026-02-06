package com.salesianostriana.viviendafilter.validations;

import jakarta.validation.ConstraintValidator;

public class MetrosCuadradosLimiteValidator implements ConstraintValidator<MetrosCuadradosLimite, Integer> {

    int max;

    @Override
    public void initialize(MetrosCuadradosLimite constraintAnnotation) {
        max = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer integer, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && integer <= max;
    }
}

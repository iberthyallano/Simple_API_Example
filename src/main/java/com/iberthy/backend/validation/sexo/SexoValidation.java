package com.iberthy.backend.validation.sexo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexoValidation implements ConstraintValidator<SexoValidate, String> {
    @Override
    public void initialize(SexoValidate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String sexo, ConstraintValidatorContext constraintValidatorContext) {

        if(sexo ==  null){
            return false;
        }else if(!sexo.equals("F") && !sexo.equals("M") && !sexo.equals("N")){
            return false;
        }

        return true;
    }
}

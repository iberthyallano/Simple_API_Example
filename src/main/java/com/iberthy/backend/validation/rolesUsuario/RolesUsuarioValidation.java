package com.iberthy.backend.validation.rolesUsuario;

import com.iberthy.backend.domain.enums.TipoRoles;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class RolesUsuarioValidation implements ConstraintValidator<RolesUsuarioValidate, List<String>> {

    @Override
    public void initialize(RolesUsuarioValidate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<String> roles, ConstraintValidatorContext constraintValidatorContext) {

        if(roles!= null && !roles.isEmpty()){
            for (String role : roles) {
                if(!role.equals(TipoRoles.ADMINISTRADOR.name()) && !role.equals(TipoRoles.FUNCIONARIO.name())){return false;}
            }
        }

        return true;
    }
}

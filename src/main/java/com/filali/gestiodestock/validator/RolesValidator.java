package com.filali.gestiodestock.validator;


import com.filali.gestiodestock.dto.RolesDto;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public static List<String> validate(RolesDto rolesDto){
        List<String> errors = new ArrayList<>();

        if(rolesDto == null){
            errors.add("Veuillez renseigner la role d'utilisateur");
            errors.add("Veuillez renseigner l'utilisateur");



            return errors;
        }
        if(rolesDto.getRoleName() == null){
            errors.add("Veuillez renseigner la role d'utilisateur");
        }
        if(rolesDto.getUtilisateur() == null){
            errors.add("Veuillez renseigner l'utilisateur");
        }



        return errors;

    }
}

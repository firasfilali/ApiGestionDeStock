package com.filali.gestiodestock.validator;

import com.filali.gestiodestock.dto.RolesDto;
import com.filali.gestiodestock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {
    public static List<String> validate(VentesDto ventesDto){
        List<String> errors = new ArrayList<>();

        if(ventesDto == null){
            errors.add("Veuillez renseigner code de vente");
            errors.add("Veuillez renseigner date de vente");



            return errors;
        }
        if(!StringUtils.hasLength(ventesDto.getCode())){
            errors.add("Veuillez renseigner code de vente");
        }
        if(ventesDto.getDateVente() == null){
            errors.add("Veuillez renseigner date de vente");
        }



        return errors;

    }
}

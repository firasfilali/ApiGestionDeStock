package com.filali.gestiodestock.validator;

import com.filali.gestiodestock.dto.EntrepriseDto;
import com.filali.gestiodestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null){
            errors.add("Veuillez renseigner le nom du fournisseur");
            errors.add("Veuillez renseigner le code fiscal du l'entreprise");
            errors.add("Veuillez renseigner le mail du l'entreprise");
            errors.add("Veuillez renseigner le numero de telephone du l'entreprise");

            return errors;
        }
        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Veuillez renseigner le nom du l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("Veuillez renseigner le code fiscal du l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("Veuillez renseigner le mail du l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Veuillez renseigner le numero de telephone du l'entreprise");
        }


        return errors;

    }
}

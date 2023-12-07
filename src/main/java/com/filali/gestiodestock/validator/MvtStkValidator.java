package com.filali.gestiodestock.validator;

import com.filali.gestiodestock.dto.LigneVenteDto;
import com.filali.gestiodestock.dto.MvtStkDto;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {
    public static List<String> validate(MvtStkDto mvtStkDto){
        List<String> errors = new ArrayList<>();

        if(mvtStkDto == null){
            errors.add("Veuillez renseigner la date du mouvement");
            errors.add("Veuillez renseigner l'article de ventes");
            errors.add("Veuillez renseigner la quantité du mouvement");
            errors.add("Veuillez renseigner le type du mouvement");


            return errors;
        }
        if(mvtStkDto.getDateMvt() == null){
            errors.add("Veuillez renseigner la date du mouvement");
        }
        if(mvtStkDto.getArticle() == null){
            errors.add("Veuillez renseigner l'article de ventes");
        }
        if(mvtStkDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantité du mouvement");
        }
        if(mvtStkDto.getTypeMvt() == null){
            errors.add("Veuillez renseigner le type du mouvement");
        }


        return errors;

    }
}

package com.filali.gestiodestock.validator;

import com.filali.gestiodestock.dto.CommandeClientDto;
import com.filali.gestiodestock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
        List<String> errors = new ArrayList<>();

        if(ligneCommandeClientDto == null){
            errors.add("Veuillez renseigner l'article de la ligne commande client");
            errors.add("Veuillez ajouter la commande client");
            errors.add("Veuillez renseigner la quantité de la ligne commande client");
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande client");


            return errors;
        }
        if(ligneCommandeClientDto.getArticle() == null){
            errors.add("Veuillez renseigner l'article de la ligne commande client");
        }
        if(ligneCommandeClientDto.getCommandeClient() == null){
            errors.add("Veuillez ajouter la commande client");
        }
        if(ligneCommandeClientDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantité de la ligne commande client");
        }
        if(ligneCommandeClientDto.getPrixUnitaire() == null){
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande client");
        }

        return errors;

    }
}

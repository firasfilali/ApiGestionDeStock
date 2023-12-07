package com.filali.gestiodestock.validator;

import com.filali.gestiodestock.dto.LigneCommandeClientDto;
import com.filali.gestiodestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        List<String> errors = new ArrayList<>();

        if(ligneCommandeFournisseurDto == null){
            errors.add("Veuillez renseigner l'article de la ligne commande fournisseur");
            errors.add("Veuillez ajouter la commande fournisseur");
            errors.add("Veuillez renseigner la quantité de la ligne commande fournisseur");
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande fournisseur");


            return errors;
        }
        if(ligneCommandeFournisseurDto.getArticle() == null){
            errors.add("Veuillez renseigner l'article de la ligne commande fournisseur");
        }
        if(ligneCommandeFournisseurDto.getCommandeFournisseur() == null){
            errors.add("Veuillez ajouter la commande fournisseur");
        }
        if(ligneCommandeFournisseurDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantité de la ligne commande fournisseur");
        }
        if(ligneCommandeFournisseurDto.getPrixUnitaire() == null){
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande fournisseur");
        }

        return errors;

    }
}

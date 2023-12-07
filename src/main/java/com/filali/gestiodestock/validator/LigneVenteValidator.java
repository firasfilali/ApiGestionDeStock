package com.filali.gestiodestock.validator;

import com.filali.gestiodestock.dto.LigneCommandeFournisseurDto;
import com.filali.gestiodestock.dto.LigneVenteDto;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {
    public static List<String> validate(LigneVenteDto ligneVenteDto){
        List<String> errors = new ArrayList<>();

        if(ligneVenteDto == null){
            errors.add("Veuillez renseigner l'article de la ligne commande fournisseur");
            errors.add("Veuillez ajouter la commande fournisseur");
            errors.add("Veuillez renseigner la quantité de la ligne commande fournisseur");
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande fournisseur");


            return errors;
        }
        if(ligneVenteDto.getVentes() == null){
            errors.add("Veuillez renseigner la vente");
        }
        if(ligneVenteDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantité de ventes");
        }
        if(ligneVenteDto.getPrixUnitaire() == null){
            errors.add("Veuillez renseigner le prix unitaire de la ventes");
        }


        return errors;

    }
}

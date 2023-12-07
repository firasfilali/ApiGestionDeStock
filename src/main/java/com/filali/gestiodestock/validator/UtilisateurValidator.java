package com.filali.gestiodestock.validator;

import com.filali.gestiodestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mdp d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");

            return errors;
        }

        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner le mail d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuillez renseigner le mdp d'utilisateur");
        }
        if(utilisateurDto.getDateDeNaissance() == null){
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }

        if(utilisateurDto.getAdresse() == null){
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
        }else{
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("Le champs 'Adresse 1' est obligatoir");
            }

            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("Le champs 'ville' est obligatoir");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("Le champs 'Code postale' est obligatoir");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("Le champs 'Pays' est obligatoir");
            }
        }



        return errors;
    }
}

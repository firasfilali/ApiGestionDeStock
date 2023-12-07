package com.filali.gestiodestock.dto;



import com.filali.gestiodestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private String description;
    private AdresseDto adresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numTel;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise == null){
            return null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .email(entreprise.getEmail())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto == null){
            return null;
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));

        return entreprise;


    }
}

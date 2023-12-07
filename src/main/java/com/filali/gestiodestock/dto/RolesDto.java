package com.filali.gestiodestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filali.gestiodestock.model.Fournisseur;
import com.filali.gestiodestock.model.Roles;
import com.filali.gestiodestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class RolesDto {
    private Integer id;
    private String roleName;
    @JsonIgnore
    private UtilisateurDto utilisateur;

    public static RolesDto fromEntity(Roles roles){
        if(roles == null){
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto){
        if(rolesDto == null){
            return null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateur()));

        return roles;
    }
}

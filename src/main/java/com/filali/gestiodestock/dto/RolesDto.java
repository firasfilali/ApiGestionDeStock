package com.filali.gestiodestock.dto;

import com.filali.gestiodestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class RolesDto {
    private String roleName;
    private UtilisateurDto utilisateur;
}

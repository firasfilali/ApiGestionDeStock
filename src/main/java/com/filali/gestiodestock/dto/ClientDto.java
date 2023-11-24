package com.filali.gestiodestock.dto;

import com.filali.gestiodestock.model.Adresse;
import com.filali.gestiodestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class ClientDto {

    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String email;
    private String numTel;
    private List<CommandeClientDto> commandeClients;
}

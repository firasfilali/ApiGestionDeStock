package com.filali.gestiodestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.filali.gestiodestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class ClientDto {
    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private Integer idEntreprise;
    private String email;
    private String numTel;
    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .email(client.getEmail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();

    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setEmail(clientDto.getEmail());
        client.setNumTel(clientDto.getNumTel());
        client.setIdEntreprise(clientDto.getIdEntreprise());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));

        return client;

    }


}

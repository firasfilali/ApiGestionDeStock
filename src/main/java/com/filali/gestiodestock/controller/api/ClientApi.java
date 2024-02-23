package com.filali.gestiodestock.controller.api;

import com.filali.gestiodestock.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.APP_ROOT;

public interface ClientApi {
    @Operation(
            description = "Cette methode permet d'enregistrer ou modifier un client",
            summary = "Enregistrer un client",
            responses = {
                    @ApiResponse(
                            description = "L'objet client cree / modifier",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "L'objet client n'est pas valide / modifier",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);
    @Operation(
            description = "Cette methode permet de chercher un client par son ID",
            summary = "Rechercher un client par ID",
            responses = {
                    @ApiResponse(
                            description = "Le client a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun client n'existe dans la BDD avec l'ID fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value =APP_ROOT + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);
    @Operation(
            description = "Cette methode permet de chercher un client par son NOM",
            summary = "Rechercher un client par NOM",
            responses = {
                    @ApiResponse(
                            description = "Le client a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun client n'existe dans la BDD avec le NOM fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value =APP_ROOT + "/clients/{clientName}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByClientName(@PathVariable("clientName") String clientName);
    @Operation(
            description = "Cette methode permet de chercher et renvoyer la listes des clients qui existent",
            summary = "Renvoi la liste des clients",
            responses = {
                    @ApiResponse(
                            description = "La liste des clients / Une liste vide",
                            responseCode = "200"
                    ),

            }
    )
    @GetMapping(value =APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();
    @Operation(
            description = "Cette methode permet de supprimer un client par ID",
            summary = "Supprimer un client",
            responses = {
                    @ApiResponse(
                            description = "Cette methode permet de supprimer un client par ID",
                            responseCode = "200"
                    ),

            }
    )
    @DeleteMapping(value =APP_ROOT + "/clients/delete/{idClient}" )
    void delete(@PathVariable("idClient") Integer id);

}

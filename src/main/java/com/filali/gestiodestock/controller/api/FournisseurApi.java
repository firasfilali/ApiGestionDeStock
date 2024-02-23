package com.filali.gestiodestock.controller.api;


import com.filali.gestiodestock.dto.FournisseurDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.FOURNISSEUR_ENDPOINT;

public interface FournisseurApi {
    @Operation(
            description = "Cette methode permet d'enregistrer ou modifier un fournisseur",
            summary = "Enregistrer un fournisseur",
            responses = {
                    @ApiResponse(
                            description = "L'objet fournisseur cree / modifier",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "L'objet fournisseur n'est pas valide / modifier",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping(value = FOURNISSEUR_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);
    @Operation(
            description = "Cette methode permet de chercher un fournisseur par son ID",
            summary = "Rechercher un fournisseur par ID",
            responses = {
                    @ApiResponse(
                            description = "Le fournisseur a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun fournisseur n'existe dans la BDD avec l'ID fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value =FOURNISSEUR_ENDPOINT + "/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);
    @Operation(
            description = "Cette methode permet de chercher un fournisseur par son NOM",
            summary = "Rechercher un fournisseur par NOM",
            responses = {
                    @ApiResponse(
                            description = "Le fournisseur a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun fournisseur n'existe dans la BDD avec le NOM fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value =FOURNISSEUR_ENDPOINT + "/{fournisseurName}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByFournisseurName(@Parameter(name = "Accepted values [ET1, ET2]") @PathVariable("fournisseurName") String fournisseurName);
    @Operation(
            description = "Cette methode permet de chercher et renvoyer la listes des fournisseurs qui existent",
            summary = "Renvoi la liste des fournisseurs",
            responses = {
                    @ApiResponse(
                            description = "La liste des fournisseurs / Une liste vide",
                            responseCode = "200"
                    ),

            }
    )
    @GetMapping(value =FOURNISSEUR_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
    @Operation(
            description = "Cette methode permet de supprimer un fournisseur par ID",
            summary = "Supprimer un fournisseur",
            responses = {
                    @ApiResponse(
                            description = "Cette methode permet de supprimer un fournisseur par ID",
                            responseCode = "200"
                    ),

            }
    )
    @DeleteMapping(value =FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}" )
    void delete(@PathVariable("idFournisseur") Integer id);
}

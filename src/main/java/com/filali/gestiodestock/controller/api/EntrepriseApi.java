package com.filali.gestiodestock.controller.api;


import com.filali.gestiodestock.dto.EntrepriseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.ENTREPRISE_ENDPOINT;

public interface EntrepriseApi {
    @Operation(
            description = "Cette methode permet d'enregistrer ou modifier une entreprise",
            summary = "Enregistrer une entreprise",
            responses = {
                    @ApiResponse(
                            description = "L'objet entreprise cree / modifier",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "L'objet entreprise n'est pas valide / modifier",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping(value = ENTREPRISE_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);
    @Operation(
            description = "Cette methode permet de chercher une entreprise par son ID",
            summary = "Rechercher une entreprise par ID",
            responses = {
                    @ApiResponse(
                            description = "L'entreprise a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun entreprise n'existe dans la BDD avec l'ID fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value =ENTREPRISE_ENDPOINT + "/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
    @Operation(
            description = "Cette methode permet de chercher une entreprise par son NOM",
            summary = "Rechercher une entreprise par NOM",
            responses = {
                    @ApiResponse(
                            description = "L'entreprise a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun entreprise n'existe dans la BDD avec le NOM fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value =ENTREPRISE_ENDPOINT + "/{entrepriseName}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByEntrepriseName(@PathVariable("entrepriseName") String entrepriseName);
    @Operation(
            description = "Cette methode permet de chercher et renvoyer la listes des entreprises qui existent",
            summary = "Renvoi la liste des entreprises",
            responses = {
                    @ApiResponse(
                            description = "La liste des entreprises / Une liste vide",
                            responseCode = "200"
                    ),

            }
    )
    @GetMapping(value =ENTREPRISE_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();
    @Operation(
            description = "Cette methode permet de supprimer une entreprise par ID",
            summary = "Supprimer une entreprise",
            responses = {
                    @ApiResponse(
                            description = "Cette methode permet de supprimer une entreprise par ID",
                            responseCode = "200"
                    ),

            }
    )
    @DeleteMapping(value =ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}" )
    void delete(@PathVariable("idEntreprise") Integer id);
}

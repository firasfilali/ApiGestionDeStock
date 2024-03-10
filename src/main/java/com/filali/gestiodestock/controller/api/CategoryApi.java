package com.filali.gestiodestock.controller.api;


import com.filali.gestiodestock.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @Operation(
            description = "Cette methode permet d'enregistrer ou modifier une category",
            summary = "Enregistrer une category",
            responses = {
                    @ApiResponse(
                            description = "L'objet category cree / modifier",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "L'objet category n'est pas valide / modifier",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @Operation(
            description = "Cette methode permet de chercher une category par son ID",
            summary = "Rechercher une category par ID",
            responses = {
                    @ApiResponse(
                            description = "La category a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun category n'existe dans la BDD avec l'ID fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @Operation(
            description = "Cette methode permet de chercher une category par son CODE",
            summary = "Rechercher une category par CODE",
            responses = {
                    @ApiResponse(
                            description = "Category a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun category n'existe dans la BDD avec le CODE fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value = APP_ROOT + "/categories/by-code/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(@PathVariable("codeCategory") String codeCategory);

    @Operation(
            description = "Cette methode permet de chercher et renvoyer la listes des categories qui existent",
            summary = "Renvoi la liste des categories",
            responses = {
                    @ApiResponse(
                            description = "La liste des categories / Une liste vide",
                            responseCode = "200"
                    ),

            }
    )
    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();
    @Operation(
            description = "Cette methode permet de chercher et renvoyer la listes des categories filtrer par Entreprise qui existent",
            summary = "Renvoi la liste des categories par entrprise",
            responses = {
                    @ApiResponse(
                            description = "La liste des categories par entreprise / Une liste vide",
                            responseCode = "200"
                    ),

            }
    )
    @GetMapping(value = APP_ROOT + "/categories/by-entreprise/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findCategoryByEntreprise(@PathVariable("idEntreprise") Integer id );

    @Operation(
            description = "Cette methode permet de supprimer une category par ID",
            summary = "Supprimer une category",
            responses = {
                    @ApiResponse(
                            description = "Cette methode permet de supprimer une category par ID",
                            responseCode = "200"
                    ),

            }
    )
    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    void delete(@PathVariable("idCategory") Integer id);

}

package com.filali.gestiodestock.controller.api;

import com.filali.gestiodestock.dto.ArticleDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.filali.gestiodestock.utils.Constants.APP_ROOT;

import java.util.List;

public interface ArticleApi {
    @Operation(
            description = "Cette methode permet d'enregistrer ou modifier un article",
            summary = "Enregistrer un article",
            responses = {
                    @ApiResponse(
                            description = "L'objet article cree / modifier",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "L'objet article n'est pas valide / modifier",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @Operation(
            description = "Cette methode permet de chercher un article par son ID",
            summary = "Rechercher un article par ID",
            responses = {
                    @ApiResponse(
                            description = "L'article a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun article n'existe dans la BDD avec l'ID fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @Operation(
            description = "Cette methode permet de chercher un article par son CODE",
            summary = "Rechercher un article par CODE",
            responses = {
                    @ApiResponse(
                            description = "L'article a ete trouve dans la BDD",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Aucun article n'existe dans la BDD avec le CODE fourni",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @Operation(
            description = "Cette methode permet de chercher et renvoyer la listes des articles qui existent",
            summary = "Renvoi la liste des articles",
            responses = {
                    @ApiResponse(
                            description = "La liste des article / Une liste vide",
                            responseCode = "200"
                    ),

            }
    )
    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @Operation(
            description = "Cette methode permet de supprimer un article par ID",
            summary = "Supprimer un article",
            responses = {
                    @ApiResponse(
                            description = "Cette methode permet de supprimer un article par ID",
                            responseCode = "200"
                    ),

            }
    )
    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    void delete(@PathVariable("idArticle") Integer id);
}

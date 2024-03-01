package com.filali.gestiodestock.controller.api;
import com.filali.gestiodestock.dto.CommandeFournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.*;

public interface CommandeFournisseurApi {
    @PostMapping(value = COMMANDE_FOURNISSEUR_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);
    @GetMapping(value = COMMANDE_FOURNISSEUR_ENDPOINT + "/{idCommandeFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findById(@PathVariable(value = "idCommandeFournisseur") Integer id);
    @GetMapping(value = COMMANDE_FOURNISSEUR_ENDPOINT + "/{codeCommandeFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findCommandeFournisseurByCode(@PathVariable(value = "codeCommandeFournisseur") String code);
    @GetMapping(value = COMMANDE_FOURNISSEUR_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeFournisseurDto> findAll();
    @DeleteMapping(value = COMMANDE_FOURNISSEUR_ENDPOINT + "/delete/{idCommandeFournisseur}")
    void delete(@PathVariable(value = "idCommandeFournisseur") Integer id);
}

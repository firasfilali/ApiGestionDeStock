package com.filali.gestiodestock.controller.api;


import com.filali.gestiodestock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.FOURNISSEUR_ENDPOINT;

public interface FournisseurApi {
    @PostMapping(value = FOURNISSEUR_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);
    @GetMapping(value =FOURNISSEUR_ENDPOINT + "/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);
    @GetMapping(value =FOURNISSEUR_ENDPOINT + "/{fournisseurName}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByFournisseurName(@PathVariable("fournisseurName") String fournisseurName);
    @GetMapping(value =FOURNISSEUR_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
    @DeleteMapping(value =FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}" )
    void delete(@PathVariable("idFournisseur") Integer id);
}

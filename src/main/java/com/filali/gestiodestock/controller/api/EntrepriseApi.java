package com.filali.gestiodestock.controller.api;


import com.filali.gestiodestock.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.ENTREPRISE_ENDPOINT;

public interface EntrepriseApi {
    @PostMapping(value = ENTREPRISE_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);
    @GetMapping(value =ENTREPRISE_ENDPOINT + "/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
    @GetMapping(value =ENTREPRISE_ENDPOINT + "/{entrepriseName}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByEntrepriseName(@PathVariable("entrepriseName") String entrepriseName);
    @GetMapping(value =ENTREPRISE_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();
    @DeleteMapping(value =ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}" )
    void delete(@PathVariable("idEntreprise") Integer id);
}

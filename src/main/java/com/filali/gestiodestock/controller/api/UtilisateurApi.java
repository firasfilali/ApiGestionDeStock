package com.filali.gestiodestock.controller.api;

import com.filali.gestiodestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import static com.filali.gestiodestock.utils.Constants.UTILISATEUR_ENDPOINT;
import java.util.List;

public interface UtilisateurApi {
    @PostMapping(value = UTILISATEUR_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);
    @GetMapping(value = UTILISATEUR_ENDPOINT + "/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable(value = "idUtilisateur") Integer id);
    @GetMapping(value = UTILISATEUR_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();
    @DeleteMapping(value = UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable(value = "idUtilisateur") Integer id);
}

package com.filali.gestiodestock.controller.api;

import com.filali.gestiodestock.dto.CommandeClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.filali.gestiodestock.utils.Constants.APP_ROOT;

import java.util.List;

public interface CommandeClientApi {
    @Operation(
            description = "Cette methode permet d'enregistrer ou modifier une commande client",
            summary = "Enregistrer une commande client",
            responses = {
                    @ApiResponse(
                            description = "L'objet commande client cree / modifier",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "L'objet commande client n'est pas valide / modifier",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping(value = APP_ROOT + "/commandesclients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);
    @GetMapping(value = APP_ROOT + "/commandesclients/{idCommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);
    @GetMapping(value = APP_ROOT + "/commandesclients/{codeCommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);
    @GetMapping(value = APP_ROOT + "/commandesclients/all", produces = MediaType.APPLICATION_JSON_VALUE )
    ResponseEntity<List<CommandeClientDto>> findAll();
    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
    ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);
}

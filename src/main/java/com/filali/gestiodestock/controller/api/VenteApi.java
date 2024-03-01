package com.filali.gestiodestock.controller.api;

import com.filali.gestiodestock.dto.VentesDto;
import org.springframework.web.bind.annotation.*;

import static com.filali.gestiodestock.utils.Constants.VENTE_ENDPOINT;

import java.util.List;

public interface VenteApi {
    @PostMapping(VENTE_ENDPOINT + "/create")
    VentesDto save(@RequestBody VentesDto dto);
    @GetMapping(VENTE_ENDPOINT + "/{idVente}")
    VentesDto findById(@PathVariable(name = "idVente") Integer id);
    @GetMapping(VENTE_ENDPOINT + "/{codeVente}")
    VentesDto findByCode(@PathVariable(name = "codeVente") String code);
    @GetMapping(VENTE_ENDPOINT + "/all")
    List<VentesDto> findAll();
    @DeleteMapping(VENTE_ENDPOINT + "/delete/{idVente}")
    void delete(@PathVariable(name = "idVente") Integer id);
}

package com.filali.gestiodestock.controller;

import com.filali.gestiodestock.controller.api.VenteApi;
import com.filali.gestiodestock.dto.VentesDto;
import com.filali.gestiodestock.services.VenteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Tag(name = "Ventes Controller")
public class VenteController implements VenteApi {
    private VenteService venteService;
    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return venteService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return venteService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return venteService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        venteService.delete(id);

    }
}

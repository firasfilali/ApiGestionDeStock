package com.filali.gestiodestock.controller;

import com.filali.gestiodestock.controller.api.FournisseurApi;
import com.filali.gestiodestock.dto.FournisseurDto;
import com.filali.gestiodestock.services.FournisseurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Tag(name = "Fournisseur")
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public FournisseurDto findByFournisseurName(String fournisseurName) {
        return fournisseurService.findByFournisseurName(fournisseurName);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}

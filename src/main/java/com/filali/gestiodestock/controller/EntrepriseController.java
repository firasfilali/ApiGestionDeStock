package com.filali.gestiodestock.controller;

import com.filali.gestiodestock.controller.api.EntrepriseApi;
import com.filali.gestiodestock.dto.EntrepriseDto;
import com.filali.gestiodestock.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;
    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findByEntrepriseName(String entrepriseName) {
        return entrepriseService.findByEntrepriseName(entrepriseName);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}

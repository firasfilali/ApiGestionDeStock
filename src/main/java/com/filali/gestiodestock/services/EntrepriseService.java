package com.filali.gestiodestock.services;


import com.filali.gestiodestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save(EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByEntrepriseName(String nom);


    List<EntrepriseDto> findAll();

    void delete(Integer id);
}

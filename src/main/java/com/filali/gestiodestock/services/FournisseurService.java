package com.filali.gestiodestock.services;


import com.filali.gestiodestock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    FournisseurDto findByFournisseurName(String fournisseurName);

    List<FournisseurDto> findAll();
    void delete(Integer id);
}

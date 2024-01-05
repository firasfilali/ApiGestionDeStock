package com.filali.gestiodestock.services;


import com.filali.gestiodestock.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    CommandeFournisseurDto findById(Integer id);

    List<CommandeFournisseurDto> findAll();
    void delete(Integer id);
}

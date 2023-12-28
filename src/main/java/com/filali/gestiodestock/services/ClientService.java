package com.filali.gestiodestock.services;


import com.filali.gestiodestock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);

    ClientDto findById(Integer id);

    ClientDto findByClientName(String clientName);
    List<ClientDto> findAll();

    void delete(Integer id);
}

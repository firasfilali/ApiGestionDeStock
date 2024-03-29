package com.filali.gestiodestock.controller;

import com.filali.gestiodestock.controller.api.ClientApi;
import com.filali.gestiodestock.dto.ClientDto;
import com.filali.gestiodestock.services.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "Client")
@RestController
public class ClientController implements ClientApi {

    private ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto findByClientName(String clientName) {
        return clientService.findByClientName(clientName);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);

    }
}

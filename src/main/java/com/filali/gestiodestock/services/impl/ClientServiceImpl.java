package com.filali.gestiodestock.services.impl;

import com.filali.gestiodestock.dto.CategoryDto;
import com.filali.gestiodestock.dto.ClientDto;
import com.filali.gestiodestock.exception.EntityNotFoundException;
import com.filali.gestiodestock.exception.ErrorCodes;
import com.filali.gestiodestock.exception.InvalidEntityException;
import com.filali.gestiodestock.model.Category;
import com.filali.gestiodestock.model.Client;
import com.filali.gestiodestock.repository.ClientRepository;
import com.filali.gestiodestock.services.ClientService;
import com.filali.gestiodestock.validator.CategoryValidator;
import com.filali.gestiodestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", clientDto);
            throw new InvalidEntityException("Client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        Client saveClient = clientRepository.save(ClientDto.toEntity(clientDto));
        return ClientDto.fromEntity(saveClient);
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun client avec l'ID = " + id + "n'ete trouver dans BDD",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public ClientDto findByClientName(String clientName) {
        if (!StringUtils.hasLength(clientName)) {
            log.error("Client NAME is null");
            return null;
        }
        Optional<Client> client = clientRepository.findClientByNom(clientName);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun client avec le NOM = " + clientName + "n'ete trouver dans BDD",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category CODE is null");
            return;
        }
        clientRepository.deleteById(id);

    }
}

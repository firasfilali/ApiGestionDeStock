package com.filali.gestiodestock.services.impl;

import com.filali.gestiodestock.dto.CategoryDto;
import com.filali.gestiodestock.dto.UtilisateurDto;
import com.filali.gestiodestock.exception.EntityNotFoundException;
import com.filali.gestiodestock.exception.ErrorCodes;
import com.filali.gestiodestock.exception.InvalidEntityException;
import com.filali.gestiodestock.model.Category;
import com.filali.gestiodestock.model.Utilisateur;
import com.filali.gestiodestock.repository.UtilisateurRepository;
import com.filali.gestiodestock.services.UtilisateurService;
import com.filali.gestiodestock.validator.CategoryValidator;
import com.filali.gestiodestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImp implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImp(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if (!errors.isEmpty()) {
            log.error("User is not valid {}", utilisateurDto);
            throw new InvalidEntityException("Utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        Utilisateur saveUser = utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto));
        return UtilisateurDto.fromEntity(saveUser);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("User ID is null");
            return null;
        }
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(user.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun utilisateur avec l'ID = " + id + "n'ete trouver dans BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("User ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);

    }
}

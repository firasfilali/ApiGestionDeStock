package com.filali.gestiodestock.services.impl;

import com.filali.gestiodestock.dto.CategoryDto;
import com.filali.gestiodestock.dto.EntrepriseDto;
import com.filali.gestiodestock.exception.EntityNotFoundException;
import com.filali.gestiodestock.exception.ErrorCodes;
import com.filali.gestiodestock.exception.InvalidEntityException;
import com.filali.gestiodestock.model.Category;
import com.filali.gestiodestock.model.Entreprise;
import com.filali.gestiodestock.repository.EntrepriseRepository;
import com.filali.gestiodestock.services.EntrepriseService;
import com.filali.gestiodestock.validator.CategoryValidator;
import com.filali.gestiodestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;
    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("Entreprise is not valid {}", entrepriseDto);
            throw new InvalidEntityException("Entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        Entreprise saveEntreprise = entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto));
        return EntrepriseDto.fromEntity(saveEntreprise);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null){
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun entreprise avec l'ID = "+ id + "n'ete trouver dans BDD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findByEntrepriseName(String entrepriseName) {
        if(!StringUtils.hasLength(entrepriseName)){
            log.error("Entreprise NAME is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByNom(entrepriseName);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucune entreprise avec le NOM = "+ entrepriseName + "n'ete trouver dans BDD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Entreprise NAME is null");
            return;
        }
        entrepriseRepository.deleteById(id);

    }
}

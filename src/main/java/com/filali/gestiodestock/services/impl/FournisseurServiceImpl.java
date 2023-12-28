package com.filali.gestiodestock.services.impl;

import com.filali.gestiodestock.dto.ArticleDto;
import com.filali.gestiodestock.dto.FournisseurDto;
import com.filali.gestiodestock.exception.EntityNotFoundException;
import com.filali.gestiodestock.exception.ErrorCodes;
import com.filali.gestiodestock.exception.InvalidEntityException;
import com.filali.gestiodestock.model.Article;
import com.filali.gestiodestock.model.Fournisseur;
import com.filali.gestiodestock.repository.FournisseurRepository;
import com.filali.gestiodestock.services.FournisseurService;
import com.filali.gestiodestock.validator.ArticleValidator;
import com.filali.gestiodestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if (!errors.isEmpty()) {
            log.error("Fournisseur is not valid {}", fournisseurDto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }

        Fournisseur savedFournisseur = fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto));
        return FournisseurDto.fromEntity(savedFournisseur);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id == null){
            log.error("Fournisseur ID is null");
            return null;
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun fournisseur avec l'ID = "+ id + "n'ete trouver dans BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public FournisseurDto findByFournisseurName(String fournisseurName) {
        if(!StringUtils.hasLength(fournisseurName)){
            log.error("Fournisseur NAME is null");
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findFournisseurByNom(fournisseurName);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun fournisseur avec le NOM = "+ fournisseurName + "n'ete trouver dans BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Fournisseur NAME is null");
            return;
        }
        fournisseurRepository.deleteById(id);

    }
}

package com.filali.gestiodestock.services.impl;

import com.filali.gestiodestock.dto.CommandeClientDto;
import com.filali.gestiodestock.dto.LigneCommandeClientDto;
import com.filali.gestiodestock.dto.LigneVenteDto;
import com.filali.gestiodestock.dto.VentesDto;
import com.filali.gestiodestock.exception.EntityNotFoundException;
import com.filali.gestiodestock.exception.ErrorCodes;
import com.filali.gestiodestock.exception.InvalidEntityException;
import com.filali.gestiodestock.model.Article;
import com.filali.gestiodestock.model.LigneCommandeClient;
import com.filali.gestiodestock.model.LigneVente;
import com.filali.gestiodestock.model.Ventes;
import com.filali.gestiodestock.repository.ArticleRepository;
import com.filali.gestiodestock.repository.LigneVenteRepository;
import com.filali.gestiodestock.repository.VentesRepository;
import com.filali.gestiodestock.services.VenteService;
import com.filali.gestiodestock.validator.CommandeFournisseurValidator;
import com.filali.gestiodestock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {
    private LigneVenteRepository ligneVenteRepository;
    private ArticleRepository articleRepository;
    private VentesRepository ventesRepository;
    @Autowired
    public VenteServiceImpl(LigneVenteRepository ligneVenteRepository, ArticleRepository articleRepository,
                            VentesRepository ventesRepository) {
        this.ligneVenteRepository = ligneVenteRepository;
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Vente n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID,errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if(article.isEmpty()){
                articleErrors.add("Aucun article avec l'ID" + ligneVenteDto.getArticle().getId() + "n'a ete trouver dans la BD");
            }
         });

        if(!articleErrors.isEmpty()){
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("Un ou plusieur articles n'ont pas ete trouvé dans la BDD", ErrorCodes.VENTE_NOT_VALID,errors);
        }

        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));


            dto.getLigneVentes().forEach(ligneVenteDto -> {
                LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
                ligneVente.setVentes(savedVentes);
                ligneVenteRepository.save(ligneVente);
            });

        return VentesDto.fromEntity(savedVentes);





    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun vente n'a ete trouve avec l'ID" + id, ErrorCodes.VENTE_NOT_FOUND
                ));
    }

    @Override
    public VentesDto findByCode(String code) {
        if (code == null) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun vente n'a ete trouve avec le CODE" + code, ErrorCodes.VENTE_NOT_FOUND
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Vente ID is NULL");
            return;
        }
        ventesRepository.deleteById(id);

    }
}

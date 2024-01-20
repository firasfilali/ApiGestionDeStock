package com.filali.gestiodestock.services.impl;



import com.filali.gestiodestock.dto.CommandeFournisseurDto;

import com.filali.gestiodestock.dto.LigneCommandeFournisseurDto;
import com.filali.gestiodestock.exception.EntityNotFoundException;
import com.filali.gestiodestock.exception.ErrorCodes;
import com.filali.gestiodestock.exception.InvalidEntityException;
import com.filali.gestiodestock.model.*;
import com.filali.gestiodestock.repository.ArticleRepository;
import com.filali.gestiodestock.repository.CommandeFournisseurRepository;
import com.filali.gestiodestock.repository.FournisseurRepository;
import com.filali.gestiodestock.repository.LigneCommandeFournisseurRepository;
import com.filali.gestiodestock.services.CommandeFournisseurService;
import com.filali.gestiodestock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;
    @Autowired
    public CommandeFournisseurImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                   LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
                                   FournisseurRepository fournisseurRepository,
                                   ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Commande fournisseur n'est pas valide");
            throw new InvalidEntityException("Commande fournisseur n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if (fournisseur.isEmpty()){
            log.warn("Fournisseur with ID {} was not found in DB ", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'ID" + dto.getFournisseur().getId() +
                    "n'a ete trouve dans BD ", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articlesErrors = new ArrayList<>();

        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdFou -> {
                if (ligCmdFou.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdFou.getArticle().getId());
                    if (article.isEmpty()) {
                        articlesErrors.add("L'article avec l'ID" + ligCmdFou.getArticle().getId() + "n'existe pas");
                    }
                } else {
                    articlesErrors.add("Impossible d'enregistrer une commande avec un article NULL");
                }
            });
        }
        if (!articlesErrors.isEmpty()) {
            log.warn("Article n'existe pas dans la BDD");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articlesErrors);
        }
        CommandeFournisseur saveCmdFou = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdFou -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdFou);
                ligneCommandeFournisseur.setCommandeFournisseur(saveCmdFou);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }


        return CommandeFournisseurDto.fromEntity(saveCmdFou);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Commande fournisseur ID is NULL");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun commande fournisseur n'a ete trouve avec l'ID" + id, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public CommandeFournisseurDto findCommandeFournisseurByCode(String code) {
        if (code == null) {
            log.error("Commande fournisseur CODE is NULL");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun commande fournisseur n'a ete trouve avec le CODE" + code, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }


    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Commande fournisseur ID is NULL");
            return;
        }
        commandeFournisseurRepository.deleteById(id);

    }
}

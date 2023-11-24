package com.filali.gestiodestock.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Builder
@Data
public class LigneCommandeFournisseurDto {

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
}

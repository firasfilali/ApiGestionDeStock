package com.filali.gestiodestock.dto;



import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Builder
@Data
public class LigneVenteDto {

    private VentesDto ventes;

    private BigDecimal quantite;


    private BigDecimal prixUnitaire;
}

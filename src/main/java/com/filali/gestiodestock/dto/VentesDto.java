package com.filali.gestiodestock.dto;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Builder
@Data
public class VentesDto {
    private String code;
    private Instant dateVente;
    private String commentaire;
}

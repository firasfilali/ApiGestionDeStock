package com.filali.gestiodestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstarctEntity {
    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes ventes;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "quantite")
    private BigDecimal quantite;
    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

}

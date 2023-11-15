package com.filali.gestiodestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstarctEntity {
    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes ventes;

    private BigDecimal quantite;
}

package com.filali.gestiodestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventes")
public class Ventes extends AbstarctEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "datevente")
    private Instant dateVente;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @Column(name = "commentaire")
    private String commentaire;
    @OneToMany(mappedBy = "ventes")
    private List<LigneVente> ligneVentes;
}

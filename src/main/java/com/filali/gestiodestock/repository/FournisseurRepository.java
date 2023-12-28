package com.filali.gestiodestock.repository;

import com.filali.gestiodestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
    Optional<Fournisseur> findFournisseurByNom(String fournisseurName);
}

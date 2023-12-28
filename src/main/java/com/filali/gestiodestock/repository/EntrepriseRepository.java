package com.filali.gestiodestock.repository;

import com.filali.gestiodestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer > {
    Optional<Entreprise> findEntrepriseByNom(String entrepriseName);
}

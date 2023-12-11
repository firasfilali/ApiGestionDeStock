package com.filali.gestiodestock.repository;

import com.filali.gestiodestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise> {
}

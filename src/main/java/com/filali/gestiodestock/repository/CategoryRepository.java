package com.filali.gestiodestock.repository;


import com.filali.gestiodestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findCategoryByCode(String codearticle);

    @Query(value = "SELECT c FROM Category c WHERE c.idEntreprise = ?1")
    List<Category> findCategoryByEntreprise(Integer idEntreprise);




}

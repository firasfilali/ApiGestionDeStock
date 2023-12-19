package com.filali.gestiodestock.repository;

import com.filali.gestiodestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

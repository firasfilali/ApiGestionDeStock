package com.filali.gestiodestock.services;

import com.filali.gestiodestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String codeCategory);

    List<CategoryDto> findAll();

    List<CategoryDto> findCategoryByEntreprise(Integer id );

    void delete(Integer id);
}

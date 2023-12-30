package com.filali.gestiodestock.services.impl;


import com.filali.gestiodestock.dto.CategoryDto;
import com.filali.gestiodestock.exception.EntityNotFoundException;
import com.filali.gestiodestock.exception.ErrorCodes;
import com.filali.gestiodestock.exception.InvalidEntityException;

import com.filali.gestiodestock.model.Category;
import com.filali.gestiodestock.repository.CategoryRepository;
import com.filali.gestiodestock.services.CategoryService;

import com.filali.gestiodestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if (!errors.isEmpty()) {
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("Category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        Category saveCategory = categoryRepository.save(CategoryDto.toEntity(categoryDto));
        return CategoryDto.fromEntity(saveCategory);
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun category avec l'ID = " + id + "n'ete trouver dans BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }


    @Override
    public CategoryDto findByCode(String codeCategory) {
        if (!StringUtils.hasLength(codeCategory)) {
            log.error("Category CODE is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoryByCode(codeCategory);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun category avec le CODE = " + codeCategory + "n'ete trouver dans BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category CODE is null");
            return;
        }
        categoryRepository.deleteById(id);

    }
}

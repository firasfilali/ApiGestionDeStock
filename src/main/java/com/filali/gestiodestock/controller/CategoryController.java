package com.filali.gestiodestock.controller;

import com.filali.gestiodestock.controller.api.CategoryApi;
import com.filali.gestiodestock.dto.CategoryDto;
import com.filali.gestiodestock.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Category")
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        return categoryService.findByCode(codeCategory);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public List<CategoryDto> findCategoryByEntreprise(Integer id) {
        return categoryService.findCategoryByEntreprise(id);
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}

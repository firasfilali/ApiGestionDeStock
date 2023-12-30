package com.filali.gestiodestock.controller.api;


import com.filali.gestiodestock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.filali.gestiodestock.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);
    @GetMapping(value =APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);
    @GetMapping(value =APP_ROOT + "/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(@PathVariable("codeCategory") String codeCategory);
    @GetMapping(value =APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();
    @DeleteMapping(value =APP_ROOT + "/categories/delete/{idCategory}" )
    void delete(@PathVariable("idCategory") Integer id);

}

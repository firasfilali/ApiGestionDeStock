package com.filali.gestiodestock.controller.api;

import com.filali.gestiodestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.filali.gestiodestock.utils.Constants.APP_ROOT;
import java.util.List;

public interface ArticleApi {
    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);
    @GetMapping(value =APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);
    @GetMapping(value =APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
    @GetMapping(value =APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();
    @DeleteMapping(value =APP_ROOT + "/articles/delete/{idArticle}" )
    void delete(@PathVariable("idArticle") Integer id);
}

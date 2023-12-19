package com.filali.gestiodestock.repository;

import com.filali.gestiodestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findArticleByCodeArticle(String codearticle);
}

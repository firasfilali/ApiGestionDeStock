package com.filali.gestiodestock.repository;

import com.filali.gestiodestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ArticleRepository extends JpaRepository<Integer, Article> {

}

package com.example.meu_banco_de_dados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.meu_banco_de_dados.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByName(String categoryName);

    @Query(value = "SELECT * FROM category c WHERE c.name = :categoryName", nativeQuery = true) 
    Category findCategoryByNameSQL (@Param("categoryName") String categoryName);

    
    @Query(value = "SELECT COUNT(*) FROM category c WHERE c.id = :minProductCount", nativeQuery = true)
    List<Category> findCategoriesByMinProductCount(@Param("minProductCount") int categoryName);

    
}
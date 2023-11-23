package com.example.meu_banco_de_dados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface de repositório do Spring Data JPA.
import org.springframework.data.jpa.repository.Query; // Importa a anotação de consulta personalizada do Spring Data JPA.
import org.springframework.data.repository.query.Param; // Importa a anotação de parâmetro da consulta personalizada.

import com.example.meu_banco_de_dados.model.Product;
import com.example.meu_banco_de_dados.model.Category;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByCategory(Category category);

    @Query(value = "SELECT * FROM product p WHERE p.price < :maxPrice", nativeQuery = true)
    List<Product> findProductsBelowMaxPrice(@Param("maxPrice") double maxPrice);

    @Query(value = "SELECT * FROM product WHERE category_id = (SELECT id FROM category where category.name = :categoryName)", nativeQuery = true)
    List<Product> findProuductsBycategoryName(@Param("categoryName") String categoryName);

}



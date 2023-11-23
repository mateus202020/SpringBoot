package com.example.meu_banco_de_dados.controller;

import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação de mapeamento GET. import
import org.springframework.web.bind.annotation.PathVariable; // Importa a anotação de variável de caminho. import org.springframework.web.bind.annotation. RequestMapping; // Importa a anotação de mapeamento de requisição.
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; // Importa a anotação de controlador REST. 7 import java.util.List;
import java.util.List;
import java.util.ArrayList;
import com.example.meu_banco_de_dados.model.Product;
import com.example.meu_banco_de_dados.model.Category; 
import com.example.meu_banco_de_dados.repository. ProductRepository; 
import com.example.meu_banco_de_dados.repository.CategoryRepository; 

@RestController 
@RequestMapping("/products") 
public class ProductController{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
}

@GetMapping // Mapeia o método para responder a requisições GET na rota base ("/products"). public List<Product> getAllProducts() {
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


@GetMapping("/category/{categoryId}") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (categoryId). public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
     public List<Product> getprProductsByCategory(@PathVariable long categoryId){
        Category category =  (Category) categoryRepository.findById(categoryId).orElse(null);
        if(category != null){
            return productRepository.findByCategory(category);
        }
        return new ArrayList<>();
    }
@GetMapping("/below-price/{maxPrice}") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (maxPrice). public List<Product> getProductsBelowMaxPrice(@PathVariable double maxPrice) {
    public List<Product> getProductsBelowMaxPrice(@PathVariable double maxPrice){
        return productRepository.findProductsBelowMaxPrice(maxPrice); // Retorna os produtos con preço abaixo do valor máximo.
    }

@GetMapping("/byCategoryName/{categoryName}")
    public List<Product> getProductsByCategoryName(@PathVariable String categoryName) {
        return productRepository.findProuductsBycategoryName(categoryName);
   }

}
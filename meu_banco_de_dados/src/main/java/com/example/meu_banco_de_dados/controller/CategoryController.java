package com.example.meu_banco_de_dados.controller;

import org.springframework.web.bind.annotation.*; // Importa as anotações para mapear rotas e parámetros en un controlador REST. import java.util.List;
import java.util.List;
import com.example.meu_banco_de_dados.repository.CategoryRepository; // Importa o repositório de categorias.
import com.example.meu_banco_de_dados.model.Category; // Importa a model de categorias

@RestController // Indica que esta classe é un controlador REST.
@RequestMapping("/categories") // Define o mapeamento base para todas as rotas deste controlador. 11 public class CategoryController {
public class CategoryController{

    private final CategoryRepository categoryRepository;
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository= categoryRepository;
}
@GetMapping
public List<Category> getAllCategories(){
    return categoryRepository.findAll();
}

@GetMapping("/{id}")// Mapeia o método para responder a requisições GET na rota base (&quot;/categories&quot;). public List&lt;Category&gt; getAll Categories() {
    public Category getCategoryById(@PathVariable Long id){
        return (Category) categoryRepository.findById(id).orElse(null);
}

@GetMapping("/minProductCount")
public List<Category> getCategoriesByMinProductCount(@RequestParam int minProductCount){
  return  categoryRepository.findCategoriesByMinProductCount(minProductCount);
}

@GetMapping("/byName/{categoryName}") // Mapeia o método para responder a requisições GET com un parimetro de caminho (ID). public Category getCategoryById(@PathVariable Long id) {
public Category getCategoryByName(@PathVariable String categoryName){
    return  categoryRepository.findCategoryByNameSQL(categoryName);
}

@GetMapping("/byNameSQL/{categoryName}") 
public Category getCategoryByNameSQL(@PathVariable String categoryName){
    return (Category) categoryRepository.findCategoryByNameSQL(categoryName); // Busca una categoria pelo nome usando SQL native.
}


@PostMapping // Mageia o método para responder a requisições POST.
public Category createCategory(@RequestBody Category category) {
    return (Category) categoryRepository.save(category);
}

@PutMapping("/{id}") // Mapeia o método para responder a requisições PUT com un parimetro de caminho (ID).
public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
    Category existingCategory = (Category) categoryRepository.findById(id).orElse(null); // Busca a categoria existente pelo ID. if (existingCategory = null) {
    if(existingCategory != null){
        existingCategory.setName(updatedCategory.getName()); // Atualiza o nome da categoria.
        return (Category) categoryRepository.save(existingCategory); // Salva a categoria atualizada no banco de dades.
    }  
    return null; // Retorna nulo se a categoria não for encontrada.
}

@DeleteMapping("/{id}") // Mapeia o método para responder a requisições DELETE con un parámetro de caminho (ID). public void deleteCategory(@PathVariable Long id) {}
    public void deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }
}

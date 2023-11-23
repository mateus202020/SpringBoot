package com.example.meu_banco_de_dados.model;

import jakarta.persistence.Entity; // Importa a anotação de entidade do Jakarta Persistence. import Jakarta.persistence.Generatedvalue; // Importa a anotação de geração automática. jakarta.persistence.GenerationType; // Importa a estratégia de geração automática.
import jakarta.persistence.Id; // Importa a anotação de chave primaria.
import jakarta.persistence.Column; // Importa a anotação de coluna
import jakarta.persistence.ManyToOne; // Importa a anotação de relacionamento Many-to-one. import jakarta-persistence.Jonel // Importa a antação de coluna de junção.
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;

@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cave prisiria do produt

    @Column(nullable = false)
    private String name; // Nome do produto, não pode ser nulo.

     @Column(nullable = false)
    private double price; 

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; 

    public Long getId(){
        return id;
    }
    // Setter para o ID.
    public void setId(Long id){
        this.id = id;
    }
    // Getter para o nome
    public String getName() {
       return name;
    }

   public void setName(String name) {
       this.name = name;
    }
    // Getter para o preço.
    public double getPrice(double price) {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    // Getter para a categoria.
    public Category getCategory() {
        return category;
    }
   
    // Setter para a categoria.
    public void setCategory(Category category) {
        this.category = category;
    }
}
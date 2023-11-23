package com.example.meu_banco_de_dados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Representa o ID exclusivo da categoria

@Column(nullable = false)
private String name; // Representa o nome da categoria, que não

public Long getId(){
    return id;
}

public void setId(Long id){
    this.id = id;
}


public String getName(){
    return name;
}

public void setName(String name){
    this.name = name;
}

}


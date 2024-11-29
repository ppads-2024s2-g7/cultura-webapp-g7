package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "itemculturaltype", discriminatorType = DiscriminatorType.STRING)
@Data
@Table(name = "item_cultural")
public abstract class ItemCultural {
    
    @Id @GeneratedValue
    private long id;

    private String nome;

    public ItemCultural() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private int nota;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "geek_id")
    private Geek geek;

    @ManyToOne
    @JoinColumn(name = "item_cultural_id")
    private ItemCultural itemCultural;
    
    public Avaliacao() {
        super();
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Geek getGeek() {
        return geek;
    }

    public void setGeek(Geek geek) {
        this.geek = geek;
    }

    public ItemCultural getItemCultural() {
        return itemCultural;
    }

    public void setItemCultural(ItemCultural itemCultural) {
        this.itemCultural = itemCultural;
    }
}

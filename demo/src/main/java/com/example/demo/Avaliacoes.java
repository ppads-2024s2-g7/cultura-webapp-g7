package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Avaliacoes {

    @Id
    @GeneratedValue
    private long id;

    private String titulo;
    private int nota;
    private String comentario;

    public Avaliacoes() {
        super();
    }

    // Getter para o atributo id
    public long getId() {
        return id;
    }

    // Setter para o atributo id
    public void setId(long id) {x   
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

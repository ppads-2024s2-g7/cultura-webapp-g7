package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brincadeira")
public class Brincadeira {

    @Id @GeneratedValue
    private long id;

    private String nome;
    private int qtdeMinimaJogadores;
    private int qtdeMaximaJogadores;
    private String habilidadePrincipal;

    public Brincadeira() {
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

    public int getQtdeMinimaJogadores() {
        return qtdeMinimaJogadores;
    }

    public void setQtdeMinimaJogadores(int qtdeMinimaJogadores) {
        this.qtdeMinimaJogadores = qtdeMinimaJogadores;
    }

    public int getQtdeMaximaJogadores() {
        return qtdeMaximaJogadores;
    }

    public void setQtdeMaximaJogadores(int qtdeMaximaJogadores) {
        this.qtdeMaximaJogadores = qtdeMaximaJogadores;
    }

    public String getHabilidadePrincipal() {
        return habilidadePrincipal;
    }

    public void setHabilidadePrincipal(String habilidadePrincipal) {
        this.habilidadePrincipal = habilidadePrincipal;
    }
}

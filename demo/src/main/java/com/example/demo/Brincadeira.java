package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Brincadeira extends ItemCultural{

    @Id @GeneratedValue
    private long id;

    private int qtdeMinimaJogadores;
    private int qtdeMaximaJogadores;
    private String habilidadePrincipal;

    public Brincadeira() {
        super();
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

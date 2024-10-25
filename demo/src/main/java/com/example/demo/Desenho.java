package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Desenho extends ItemCultural{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int episodios;
    private int temporadas;
    private int classificacao;
    private int duracaoEpisodio; // em minutos
    private int anoLancamento;

    // Construtor vazio
    public Desenho() {}

    // Construtor com parâmetros
    public Desenho(String nome, int episodios, int temporadas, int classificacao, int duracaoEpisodio, int anoLancamento) {
        this.episodios = episodios;
        this.temporadas = temporadas;
        this.classificacao = classificacao;
        this.duracaoEpisodio = duracaoEpisodio;
        this.anoLancamento = anoLancamento;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getDuracaoEpisodio() {
        return duracaoEpisodio;
    }

    public void setDuracaoEpisodio(int duracaoEpisodio) {
        this.duracaoEpisodio = duracaoEpisodio;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}

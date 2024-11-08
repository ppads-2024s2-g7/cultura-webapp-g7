package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;


@Entity
@DiscriminatorValue("MUSICA")
@EqualsAndHashCode(callSuper = true)
public class Musica extends ItemCultural {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String duracao;
    private String cantor;
    private String produtor;
    private int anoLancamento;

    // Construtor vazio
    public Musica() {}

    // Construtor com parâmetros
    public Musica(String duracao, String cantor, String produtor, int anoLancamento) {
        this.duracao = duracao;
        this.cantor = cantor;
        this.produtor = produtor;
        this.anoLancamento = anoLancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
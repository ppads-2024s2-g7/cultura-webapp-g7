package com.example.demo;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MUSICA")
@EqualsAndHashCode(callSuper = true)
public class Musica extends ItemCultural {

    private String cantor;
    private String produtor;
    private Integer anoLancamento;
    private Integer duracao; // Duração da música em segundos (exemplo)

    // Construtor padrão
    public Musica() {
        super();  // Chama o construtor da classe ItemCultural
    }
    
    // Construtor com parâmetros
    public Musica(String nome, String cantor, String produtor, Integer anoLancamento, Integer duracao) {
        super();  // Chama o construtor da classe ItemCultural
        this.setNome(nome); // Usa o método da classe pai para setar o nome
        this.cantor = cantor;
        this.produtor = produtor;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
    }

    // Getters e setters
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

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

}

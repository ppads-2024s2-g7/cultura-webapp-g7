package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="filme")
public class Filme extends ItemCultural{

	@Id @GeneratedValue
	private long id;

	private String nome;
    private String tempoDeDuracao;
    private int anoLancamento;
    private String genero;
		
	public Filme() {
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
	public String getTempoDeDuracao() {
		return tempoDeDuracao;
	}
	public void setTempoDeDuracao(String tempoDeDuracao) {
		this.tempoDeDuracao = tempoDeDuracao;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}



}
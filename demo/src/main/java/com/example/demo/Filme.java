package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Filme extends ItemCultural{

	@Id @GeneratedValue
	private long id;
    private String tempoDeDuracao;
    private int anoLancamento;
    private String genero;
		
	public Filme() {
		super();
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
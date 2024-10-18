package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="JogosDigitais")
public class JogosDigitais extends ItemCultural{

	@Id @GeneratedValue
	private long id;

	private String nome;
	private int idadeMinima;
    private int qtdeMinimaJogadores;
    private int qtdeMaximaJogadores;
    private int duracaoMediaMinutos;
    private int anoLancamento;

	private String area;
		
	public JogosDigitais() {
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
	public int getIdadeMinima() {
		return idadeMinima;
	}
	public void setIdadeMinima(int idadeMinima) {
		this.idadeMinima = idadeMinima;
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
	public int getDuracaoMediaMinutos() {
		return duracaoMediaMinutos;
	}
	public void setDuracaoMediaMinutos(int duracaoMediaMinutos) {
		this.duracaoMediaMinutos = duracaoMediaMinutos;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
}

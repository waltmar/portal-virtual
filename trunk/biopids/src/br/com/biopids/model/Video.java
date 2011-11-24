package br.com.biopids.model;

import java.io.Serializable;

public class Video implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private String nome;
	private String descricao;
	
	public Video(){}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}

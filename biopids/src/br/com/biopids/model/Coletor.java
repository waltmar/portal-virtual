package br.com.biopids.model;

import java.io.Serializable;



public class Coletor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public Coletor(){}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}

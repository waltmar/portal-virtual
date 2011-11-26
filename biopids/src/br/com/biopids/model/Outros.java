package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Outros implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Bibliografia> bibliografias;
	private List<Aplicacao> aplicacoes;
	
	public Outros(){
		this.bibliografias = new ArrayList<Bibliografia>();
		this.aplicacoes = new ArrayList<Aplicacao>();
	}

	public List<Bibliografia> getBibliografias() {
		return bibliografias;
	}

	public void setBibliografias(List<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	
	
}

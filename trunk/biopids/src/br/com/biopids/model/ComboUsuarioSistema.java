package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.biopids.domain.Autorizacao;

public class ComboUsuarioSistema implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Autorizacao> autorizacoes;
	
	public ComboUsuarioSistema(){
		this.autorizacoes = new ArrayList<Autorizacao>();
	}
	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	
	
	
}

package br.com.biopids.model;

import java.io.Serializable;



public class Bibliografia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valor;
	
	public Bibliografia(){}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}

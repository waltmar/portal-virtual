package br.com.biopids.model;

import java.io.Serializable;

public class BasicModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String pai;
	private String valor;
	private String codigo; 
	private String status;

	public BasicModel(){}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

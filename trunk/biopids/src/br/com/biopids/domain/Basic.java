package br.com.biopids.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="basic")
public class Basic extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private Long pai;
	private String valor;
	
	
	public Basic(){}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getPai() {
		return pai;
	}

	public void setPai(Long pai) {
		this.pai = pai;
	}
	
	
	

}

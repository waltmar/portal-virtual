package br.com.biopids.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="metodo")
public class Metodo extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valor;
	
	public Metodo(){
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}


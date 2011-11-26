package br.com.biopids.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="coletor")
public class Coletor extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valor;
	
	public Coletor(){
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}


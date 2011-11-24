package br.com.biopids.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="datum")
public class Datum extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valor;
	
	public Datum(){
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}


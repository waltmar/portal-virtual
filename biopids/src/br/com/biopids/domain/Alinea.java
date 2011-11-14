package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="alinea")
public class Alinea extends EntityPersist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	@Column(nullable=false)
	private String numero;
	
	
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}

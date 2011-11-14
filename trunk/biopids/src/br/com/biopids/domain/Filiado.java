package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="filiado")
public class Filiado extends EntityPersist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(nullable=false, unique=true)
	private String codigoFiliado;
	@Column(nullable=false)
	private String nome;
	
	public String getCodigoFiliado() {
		return codigoFiliado;
	}
	public void setCodigoFiliado(String codigoFiliado) {
		this.codigoFiliado = codigoFiliado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}

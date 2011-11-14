package br.com.biopids.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contato")
public class Contato extends EntityPersist {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7761849586746914063L;
	@Column(nullable=false)
	private String nome;
	@OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "telefone_codigo", insertable = true, updatable = true)
	private Telefone telefone;
	
	public Contato(){}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	
}

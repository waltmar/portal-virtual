package br.com.biopids.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="outros")
public class Outros extends EntityPersist{
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "outros_has_bibliografia", joinColumns = @JoinColumn(name = "outros_codigo"), inverseJoinColumns = @JoinColumn(name = "bibliografias_codigo"))
	private List<Bibliografia> bibliografias;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "outros_has_aplicacoes", joinColumns = @JoinColumn(name = "outros_codigo"), inverseJoinColumns = @JoinColumn(name = "aplicacoes_codigo"))
	private List<Aplicacao> aplicacoes;
	
	public Outros() {
		// TODO Auto-generated constructor stub
		this.bibliografias = new ArrayList<Bibliografia>();
		this.aplicacoes = new ArrayList<Aplicacao>();
	}

	public List<Bibliografia> getBibliografias() {
		return bibliografias;
	}

	public void setBibliografias(List<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}
	
	

}

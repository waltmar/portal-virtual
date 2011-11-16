package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.FieldBean;

public class SpecimenModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	@FieldBean(internalClass=true)
	private Collect collect;
	private Geography geography;
	private Taxonomy taxonomy;
	
	
	public SpecimenModel() {
		this.collect = new Collect();
		this.geography = new Geography();
		this.taxonomy = new Taxonomy();
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}



	public Geography getGeography() {
		return geography;
	}


	public void setGeography(Geography geography) {
		this.geography = geography;
	}


	public Taxonomy getTaxonomy() {
		return taxonomy;
	}


	public void setTaxonomy(Taxonomy taxonomy) {
		this.taxonomy = taxonomy;
	}
	
	
	
}

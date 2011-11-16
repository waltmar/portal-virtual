package br.com.biopids.model;

import java.io.Serializable;

public class Taxonomy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reino;
	private String filo;
	private String classe;
	private String subClasse;
	private String ordem;
	private String subOrdem;
	private String familia;
	private String subFamilia;
	private String genero;
	private String subGenero;
	private String epEspecifico;
	private String autor;
	private String dataDeterminacao;
	private String imprecisao;
	private String obsTaxonomia;
	
	public Taxonomy(){}

	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public String getFilo() {
		return filo;
	}

	public void setFilo(String filo) {
		this.filo = filo;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getSubClasse() {
		return subClasse;
	}

	public void setSubClasse(String subClasse) {
		this.subClasse = subClasse;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public String getSubOrdem() {
		return subOrdem;
	}

	public void setSubOrdem(String subOrdem) {
		this.subOrdem = subOrdem;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getSubFamilia() {
		return subFamilia;
	}

	public void setSubFamilia(String subFamilia) {
		this.subFamilia = subFamilia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSubGenero() {
		return subGenero;
	}

	public void setSubGenero(String subGenero) {
		this.subGenero = subGenero;
	}

	public String getEpEspecifico() {
		return epEspecifico;
	}

	public void setEpEspecifico(String epEspecifico) {
		this.epEspecifico = epEspecifico;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDataDeterminacao() {
		return dataDeterminacao;
	}

	public void setDataDeterminacao(String dataDeterminacao) {
		this.dataDeterminacao = dataDeterminacao;
	}

	public String getImprecisao() {
		return imprecisao;
	}

	public void setImprecisao(String imprecisao) {
		this.imprecisao = imprecisao;
	}

	public String getObsTaxonomia() {
		return obsTaxonomia;
	}

	public void setObsTaxonomia(String obsTaxonomia) {
		this.obsTaxonomia = obsTaxonomia;
	}
	

}

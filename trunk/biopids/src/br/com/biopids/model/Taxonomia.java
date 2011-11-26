package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.InnerClassDomain;

public class Taxonomia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@InnerClassDomain(local={"taxonomia","reino","codigo"})
	private String reino;
	@InnerClassDomain(local={"taxonomia","filo","codigo"})
	private String filo;
	@InnerClassDomain(local={"taxonomia","classe","codigo"})
	private String classe;
	@InnerClassDomain(local={"taxonomia","subClasse","codigo"})
	private String subClasse;
	@InnerClassDomain(local={"taxonomia","ordem","codigo"})
	private String ordem;
	@InnerClassDomain(local={"taxonomia","subOrdem","codigo"})
	private String subOrdem;
	@InnerClassDomain(local={"taxonomia","familia","codigo"})
	private String familia;
	@InnerClassDomain(local={"taxonomia","subFamilia","codigo"})
	private String subFamilia;
	@InnerClassDomain(local={"taxonomia","genero","codigo"})
	private String genero;
	@InnerClassDomain(local={"taxonomia","subGenero","codigo"})
	private String subGenero;
	@InnerClassDomain(local={"taxonomia","epEspecifico"})
	private String epEspecifico;
	@InnerClassDomain(local={"taxonomia","autor","nome"})
	private String autor;
	@InnerClassDomain(local={"taxonomia", "dataDeterminacao"})
	private String dataDeterminacao;
	@InnerClassDomain(local={"taxonomia", "imprecisao"})
	private String imprecisao;
	@InnerClassDomain(local={"taxonomia", "obsTaxonomia"})
	private String obsTaxonomia;
	
	public Taxonomia(){}

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

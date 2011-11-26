package br.com.biopids.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="taxonomia")
public class Taxonomia extends EntityPersist{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name = "reino_codigo", insertable = true, updatable = true)
	private Reino reino;
	@OneToOne
	@JoinColumn(name = "filo_codigo", insertable = true, updatable = true)
	private Filo filo;
	@OneToOne
	@JoinColumn(name = "classe_codigo", insertable = true, updatable = true)
	private Classe classe;
	@OneToOne
	@JoinColumn(name = "sub_classe_codigo", insertable = true, updatable = true)
	private SubClasse subClasse;
	@OneToOne
	@JoinColumn(name = "ordem_codigo", insertable = true, updatable = true)
	private Ordem ordem;
	@OneToOne
	@JoinColumn(name = "sub_ordem_codigo", insertable = true, updatable = true)
	private SubOrdem subOrdem;
	@OneToOne
	@JoinColumn(name = "familia_codigo", insertable = true, updatable = true)
	private Familia familia;
	@OneToOne
	@JoinColumn(name = "sub_familia_codigo", insertable = true, updatable = true)
	private SubFamilia subFamilia;
	@OneToOne
	@JoinColumn(name = "genero_codigo", insertable = true, updatable = true)
	private Genero genero;
	@OneToOne
	@JoinColumn(name = "sub_genero_codigo", insertable = true, updatable = true)
	private SubGenero subGenero;

	private String epEspecifico;
	@OneToOne
	@JoinColumn(name = "autor_codigo", insertable = true, updatable = true)
	private Autor autor;
	
	private String dataDeterminacao;
	private String imprecisao;
	private String obsTaxonomia;
	
	public Taxonomia(){}
	
	public Reino getReino() {
		return reino;
	}
	public void setReino(Reino reino) {
		this.reino = reino;
	}
	public Filo getFilo() {
		return filo;
	}
	public void setFilo(Filo filo) {
		this.filo = filo;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public SubClasse getSubClasse() {
		return subClasse;
	}
	public void setSubClasse(SubClasse subClasse) {
		this.subClasse = subClasse;
	}
	public Ordem getOrdem() {
		return ordem;
	}
	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
	public SubOrdem getSubOrdem() {
		return subOrdem;
	}
	public void setSubOrdem(SubOrdem subOrdem) {
		this.subOrdem = subOrdem;
	}
	public Familia getFamilia() {
		return familia;
	}
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	public SubFamilia getSubFamilia() {
		return subFamilia;
	}
	public void setSubFamilia(SubFamilia subFamilia) {
		this.subFamilia = subFamilia;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public SubGenero getSubGenero() {
		return subGenero;
	}
	public void setSubGenero(SubGenero subGenero) {
		this.subGenero = subGenero;
	}

	public String getEpEspecifico() {
		return epEspecifico;
	}

	public void setEpEspecifico(String epEspecifico) {
		this.epEspecifico = epEspecifico;
	}

	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
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

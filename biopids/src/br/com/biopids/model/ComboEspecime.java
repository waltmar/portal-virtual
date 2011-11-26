package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.biopids.domain.Autor;
import br.com.biopids.domain.Classe;
import br.com.biopids.domain.Datum;
import br.com.biopids.domain.Estado;
import br.com.biopids.domain.EstagioDesenvolvimento;
import br.com.biopids.domain.Familia;
import br.com.biopids.domain.Fenologia;
import br.com.biopids.domain.Filo;
import br.com.biopids.domain.Genero;
import br.com.biopids.domain.MassaDagua;
import br.com.biopids.domain.Metodo;
import br.com.biopids.domain.Municipio;
import br.com.biopids.domain.Ordem;
import br.com.biopids.domain.Pais;
import br.com.biopids.domain.Reino;
import br.com.biopids.domain.Sexo;
import br.com.biopids.domain.SubClasse;
import br.com.biopids.domain.SubFamilia;
import br.com.biopids.domain.SubGenero;
import br.com.biopids.domain.SubOrdem;
import br.com.biopids.domain.TipoMontagem;

public class ComboEspecime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Pais> paises;
	private List<Estado> estados;
	private List<Municipio> municipios;
	private List<MassaDagua> massasDagua;
	private List<Datum> datuns;

	private List<Reino> reinos;
	private List<Filo> filos;
	private List<Classe> classes;
	private List<SubClasse> subClasses;
	private List<Ordem> ordens;
	private List<SubOrdem> subOrdens;
	private List<Familia> familias;
	private List<SubFamilia> subFamilias;
	private List<Genero> generos;
	private List<SubGenero> subGeneros;
	private List<Autor> autores;

	private List<EstagioDesenvolvimento> estagiosDesenvolvimento;
	private List<Fenologia> fenologias;
	private List<Metodo> metodos;
	private List<Sexo> sexos;
	private List<TipoMontagem> tiposMontagem;

	public ComboEspecime() {
		this.paises = new ArrayList<Pais>();
		this.estados = new ArrayList<Estado>();
		this.municipios = new ArrayList<Municipio>();
		this.massasDagua = new ArrayList<MassaDagua>();
		this.datuns = new ArrayList<Datum>();

		this.reinos = new ArrayList<Reino>();
		this.filos = new ArrayList<Filo>();
		this.classes = new ArrayList<Classe>();
		this.subClasses = new ArrayList<SubClasse>();
		this.ordens = new ArrayList<Ordem>();
		this.subOrdens = new ArrayList<SubOrdem>();
		this.familias = new ArrayList<Familia>();
		this.subFamilias = new ArrayList<SubFamilia>();
		this.generos = new ArrayList<Genero>();
		this.subGeneros = new ArrayList<SubGenero>();
		this.autores = new ArrayList<Autor>();
		
		
		this.estagiosDesenvolvimento = new ArrayList<EstagioDesenvolvimento>();
		this.fenologias = new ArrayList<Fenologia>();
		this.metodos = new ArrayList<Metodo>();
		this.sexos = new ArrayList<Sexo>();
		this.tiposMontagem = new ArrayList<TipoMontagem>();
		

	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public List<MassaDagua> getMassasDagua() {
		return massasDagua;
	}

	public void setMassasDagua(List<MassaDagua> massasDagua) {
		this.massasDagua = massasDagua;
	}

	public List<Datum> getDatuns() {
		return datuns;
	}

	public void setDatuns(List<Datum> datuns) {
		this.datuns = datuns;
	}

	public List<Reino> getReinos() {
		return reinos;
	}

	public void setReinos(List<Reino> reinos) {
		this.reinos = reinos;
	}

	public List<Filo> getFilos() {
		return filos;
	}

	public void setFilos(List<Filo> filos) {
		this.filos = filos;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public List<Ordem> getOrdens() {
		return ordens;
	}

	public void setOrdens(List<Ordem> ordens) {
		this.ordens = ordens;
	}

	public List<SubOrdem> getSubOrdens() {
		return subOrdens;
	}

	public void setSubOrdens(List<SubOrdem> subOrdens) {
		this.subOrdens = subOrdens;
	}

	public List<Familia> getFamilias() {
		return familias;
	}

	public void setFamilias(List<Familia> familias) {
		this.familias = familias;
	}

	public List<SubFamilia> getSubFamilias() {
		return subFamilias;
	}

	public void setSubFamilias(List<SubFamilia> subFamilias) {
		this.subFamilias = subFamilias;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<SubGenero> getSubGeneros() {
		return subGeneros;
	}

	public void setSubGeneros(List<SubGenero> subGeneros) {
		this.subGeneros = subGeneros;
	}
	
	public List<EstagioDesenvolvimento> getEstagiosDesenvolvimento() {
		return estagiosDesenvolvimento;
	}

	public void setEstagiosDesenvolvimento(
			List<EstagioDesenvolvimento> estagiosDesenvolvimento) {
		this.estagiosDesenvolvimento = estagiosDesenvolvimento;
	}

	public List<Fenologia> getFenologias() {
		return fenologias;
	}

	public void setFenologias(List<Fenologia> fenologias) {
		this.fenologias = fenologias;
	}

	public List<Metodo> getMetodos() {
		return metodos;
	}

	public void setMetodos(List<Metodo> metodos) {
		this.metodos = metodos;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}

	public void setSexos(List<Sexo> sexos) {
		this.sexos = sexos;
	}

	public List<SubClasse> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(List<SubClasse> subClasses) {
		this.subClasses = subClasses;
	}

	public List<TipoMontagem> getTiposMontagem() {
		return tiposMontagem;
	}

	public void setTiposMontagem(List<TipoMontagem> tiposMontagem) {
		this.tiposMontagem = tiposMontagem;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	
}

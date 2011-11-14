package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComboPessoaFisica implements Serializable{
	
	private List<String> nacionalidades;
	private List<String> estados;
	private List<String> sexos;
	private List<String> estadosCivis;
	private List<String> escolaridades;
	private List<String> cidades;
	private List<String> tiposImovel;
	
	
	public ComboPessoaFisica() {
		this.nacionalidades = new ArrayList<String>();
		this.estados = new ArrayList<String>();
		this.sexos = new ArrayList<String>();
		this.estadosCivis = new ArrayList<String>();
		this.escolaridades = new ArrayList<String>();
		this.cidades = new ArrayList<String>();
		this.tiposImovel = new ArrayList<String>();
	}
	
	
	public List<String> getTiposImovel() {
		return tiposImovel;
	}


	public void setTiposImovel(List<String> tiposImovel) {
		this.tiposImovel = tiposImovel;
	}


	public List<String> getNacionalidades() {
		return nacionalidades;
	}
	public void setNacionalidades(List<String> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}
	public List<String> getEstados() {
		return estados;
	}
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	public List<String> getSexos() {
		return sexos;
	}
	public void setSexos(List<String> sexos) {
		this.sexos = sexos;
	}
	public List<String> getEstadosCivis() {
		return estadosCivis;
	}
	public void setEstadosCivis(List<String> estadosCivis) {
		this.estadosCivis = estadosCivis;
	}
	public List<String> getEscolaridades() {
		return escolaridades;
	}
	public void setEscolaridades(List<String> escolaridades) {
		this.escolaridades = escolaridades;
	}
	public List<String> getCidades() {
		return cidades;
	}
	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}
	
}

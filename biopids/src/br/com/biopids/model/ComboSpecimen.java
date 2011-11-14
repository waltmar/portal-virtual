package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComboSpecimen implements Serializable{
	
	private List<String> estagioDesenvolvimento;
	private List<String> fenologia;
	private List<String> metodo;
	private List<String> sexo;
	private List<String> tipoMontagem;
	private List<String> coletores;

	public ComboSpecimen() {
		this.estagioDesenvolvimento= new ArrayList<String>();
		this.fenologia= new ArrayList<String>();
		this.metodo= new ArrayList<String>();
		this.sexo= new ArrayList<String>();
		this.tipoMontagem= new ArrayList<String>();
		this.coletores= new ArrayList<String>();
	}

	public List<String> getEstagioDesenvolvimento() {
		return estagioDesenvolvimento;
	}

	public void setEstagioDesenvolvimento(List<String> estagioDesenvolvimento) {
		this.estagioDesenvolvimento = estagioDesenvolvimento;
	}

	public List<String> getFenologia() {
		return fenologia;
	}

	public void setFenologia(List<String> fenologia) {
		this.fenologia = fenologia;
	}

	public List<String> getMetodo() {
		return metodo;
	}

	public void setMetodo(List<String> metodo) {
		this.metodo = metodo;
	}

	public List<String> getSexo() {
		return sexo;
	}

	public void setSexo(List<String> sexo) {
		this.sexo = sexo;
	}

	public List<String> getTipoMontagem() {
		return tipoMontagem;
	}

	public void setTipoMontagem(List<String> tipoMontagem) {
		this.tipoMontagem = tipoMontagem;
	}

	public List<String> getColetores() {
		return coletores;
	}

	public void setColetores(List<String> coletores) {
		this.coletores = coletores;
	}
	
}

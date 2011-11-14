package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.biopids.domain.Alinea;
import br.com.biopids.domain.Banco;
import br.com.biopids.domain.Filiado;

public class ComboCheque implements Serializable{

	private List<Filiado> filiados;
	private List<Banco> bancos;
	private List<Alinea> alineas;

	public ComboCheque(){
		this.filiados = new ArrayList<Filiado>();
		this.bancos = new ArrayList<Banco>();
		this.alineas = new ArrayList<Alinea>();
		
	}

	public List<Filiado> getFiliados() {
		return filiados;
	}

	public void setFiliados(List<Filiado> filiados) {
		this.filiados = filiados;
	}

	public List<Banco> getBancos() {
		return bancos;
	}

	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}

	public List<Alinea> getAlineas() {
		return alineas;
	}

	public void setAlineas(List<Alinea> alineas) {
		this.alineas = alineas;
	}
	
	
	/*
	public List<SelectItem> getFiliados() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Filiado filiado : filiados) {
			list.add(new SelectItem(filiado.getCodigo(), filiado.getNome()));			
		}
		return list;
	}
	public void setFiliados(List<Filiado> filiados) {
		this.filiados = filiados;
	}
	public List<SelectItem> getBancos() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Banco banco : bancos) {
			list.add(new SelectItem(banco.getCodigo(), banco.getNome()));			
		}
		return list;
	}
	public void setBancos(List<Banco> list) {
		this.bancos = list;
	}
	public List<SelectItem> getAlineas() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Alinea alinea : alineas) {
			list.add(new SelectItem(alinea.getCodigo(), alinea.getNumero(), alinea.getDescricao()));			
		}
		return list;
	}
	public void setAlineas(List<Alinea> lista) {
		this.alineas = lista;
	}
		*/
}

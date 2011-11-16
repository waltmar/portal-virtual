package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.biopids.domain.Filiado;

public class ComboCrediario implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Filiado> filiados;
	
	public ComboCrediario() {
		this.filiados= new ArrayList<Filiado>();
	}

	public List<Filiado> getFiliados() {
		return filiados;
	}

	public void setFiliados(List<Filiado> filiados) {
		this.filiados = filiados;
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
*/
}

package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.biopids.domain.Reino;

public class ComboFilo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Reino> reinos;
	
	public ComboFilo() {
		this.reinos= new ArrayList<Reino>();
	}

	public List<Reino> getReinos() {
		return reinos;
	}

	public void setReinos(List<Reino> reinos) {
		this.reinos = reinos;
	}



	
}

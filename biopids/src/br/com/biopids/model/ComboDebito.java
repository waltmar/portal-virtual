package br.com.biopids.model;

import java.util.ArrayList;
import java.util.List;

public class ComboDebito {
	
	private List<String> Filiados;
	
	public ComboDebito() {
		this.Filiados= new ArrayList<String>();
	}

	public List<String> getFiliados() {
		return Filiados;
	}

	public void setFiliados(List<String> filiados) {
		Filiados = filiados;
	}
	
}

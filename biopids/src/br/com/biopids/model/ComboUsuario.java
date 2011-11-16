package br.com.biopids.model;

import java.util.ArrayList;
import java.util.List;

public class ComboUsuario {
	
	private List<String> empresas;
	
	public ComboUsuario(){
		this.empresas = new ArrayList<String>();
	}
	public List<String> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<String> empresas) {
		this.empresas = empresas;
	}
	
	

}

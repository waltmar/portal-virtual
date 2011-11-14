package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComboPessoaJuridica implements Serializable{
	
	private List<String> estados;
	
	public List<String> getEstados() {
		return estados;
	}
	
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	
}

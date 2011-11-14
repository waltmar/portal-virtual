package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComboDebitoPesquisa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> status;
	public List<String> getStatus() {
		return status;
	}
	public void setStatus(List<String> status) {
		this.status = status;
	}
	

	
}

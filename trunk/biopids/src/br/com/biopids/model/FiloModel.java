package br.com.biopids.model;

import br.com.biopids.annotation.InnerClassDomain;

public class FiloModel extends BasicModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@InnerClassDomain(local={"reino","codigo"})
	private String reino;

	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}
	

}

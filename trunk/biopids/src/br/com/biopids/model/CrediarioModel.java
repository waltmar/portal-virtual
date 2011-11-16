package br.com.biopids.model;

import br.com.biopids.annotation.FieldBean;

public class CrediarioModel extends DebitoModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldBean(name="numeroContrato")
	private String contrato;

	public CrediarioModel() {
		super();
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	
}

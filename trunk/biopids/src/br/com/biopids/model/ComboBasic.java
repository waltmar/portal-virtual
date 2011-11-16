package br.com.biopids.model;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Basic;


public class ComboBasic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Basic> basic;
	
	public ComboBasic(){}

	public List<Basic> getBasic() {
		return basic;
	}

	public void setBasic(List<Basic> basic) {
		this.basic = basic;
	}
	
	
}

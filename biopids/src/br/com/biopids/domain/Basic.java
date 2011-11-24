package br.com.biopids.domain;


public class Basic extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valor;
	
	public Basic(){}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	
}

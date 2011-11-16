package br.com.biopids.model;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.annotation.InnerClassDomain;
 
public class ChequeModel extends DebitoModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@InnerClassDomain(local={"banco","codigo"})
	private String banco;
	private String agencia;
	private String alinea;
	
	public ChequeModel() {
		super();
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getAlinea() {
		return alinea;
	}
	public void setAlinea(String alinea) {
		this.alinea = alinea;
	}

}

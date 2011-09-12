package br.com.scbio.exception;

public class ErrorException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypeErrors erro;
	public ErrorException(){}
	public ErrorException(TypeErrors type, String msg){
		super(msg);
		setErro(type);
	}
	public TypeErrors getErro() {
		return erro;
	}

	public void setErro(TypeErrors erro) {
		this.erro = erro;
	}
	
}

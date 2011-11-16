package br.com.biopids.exception;

public class ErrorException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypeErrors erro;
	private String message;
	public ErrorException(){}
	public ErrorException(TypeErrors type){
		super();
		setErro(type);
	}
	public ErrorException(TypeErrors type, String message){
		this.message = message;
		setErro(type);
	}
	public TypeErrors getErro() {
		return erro;
	}

	public void setErro(TypeErrors erro) {
		this.erro = erro;
	}
	
	@Override
	public String getMessage(){
		return this.message;
	}
	
}

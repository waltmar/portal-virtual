package br.com.scbio.validator;

import java.io.Serializable;

import br.com.scbio.interfaces.IValidator;


public class ServiceValidator implements Serializable{
	private static final String packageValidator = "br.com.cdlanapolis.validator."; 
	private static final long serialVersionUID = 1L;
	private String message;
	
	public boolean validate(Class<?> classValidator, String value) throws Exception{
		IValidator validator = (IValidator) classValidator.newInstance();
		validator.setValue(value);
		boolean result = validator.isValide();
		this.message = validator.getErroMessage();
		return result;
	}
	
	public boolean validate(String classValidator, String value) throws Exception{
		Class<?> classResolver = Class.forName(packageValidator + classValidator);
		return validate(classResolver, value);
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

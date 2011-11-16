package br.com.biopids.validator;

import java.io.Serializable;

public interface IValidator extends Serializable{
	
	String getErroMessage();
	void setErroMessage(String message);
	IValidator getValidatorNext();
	void setValidatorNext(IValidator validator);
	boolean isValide();
	void concat(IValidator validator);
	void setValue(Object value);
	Object getValue();
}

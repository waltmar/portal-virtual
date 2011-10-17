package br.com.scbio.interfaces;

import br.com.scbio.interfaces.IValidator;

public interface IValidator<T> {
	
	String getErroMessage();
	void setErroMessage(String message);
	IValidator getValidatorNext();
	void setValidatorNext(IValidator validator);
	boolean isValide();
	void concat(IValidator validator);
	void setValue(Object value);
	Object getValue();
}

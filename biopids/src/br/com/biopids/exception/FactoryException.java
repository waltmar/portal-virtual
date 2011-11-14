package br.com.biopids.exception;

import java.util.Collection;

import br.com.biopids.converter.MappingField;

public class FactoryException {
	
	public static ValidateException getValidateException(Collection<MappingField> fieldsWrong){
		return new ValidateException(fieldsWrong);
	}

}

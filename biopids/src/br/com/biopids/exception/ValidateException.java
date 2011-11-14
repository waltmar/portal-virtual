package br.com.biopids.exception;

import java.util.Collection;

import br.com.biopids.converter.MappingField;

public class ValidateException extends ErrorException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6529332714545325070L;
	private Collection<MappingField> fieldsWrong;
	public ValidateException(Collection<MappingField> mappingFields){
		super(TypeErrors.SEVERITY_ERROR);
		this.fieldsWrong = mappingFields;
		
	}
	
	public Collection<MappingField> getFieldsWrong() {
		return fieldsWrong;
	}

	public void setFieldsWrong(Collection<MappingField> fieldsWrong) {
		this.fieldsWrong = fieldsWrong;
	}
	

}

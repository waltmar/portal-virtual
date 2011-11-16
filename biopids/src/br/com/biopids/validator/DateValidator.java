package br.com.biopids.validator;

import java.util.Date;

import br.com.biopids.converter.GenericConverterField;

public class DateValidator extends AbstractValidator {

	
	@Override
	public boolean validate() {
		boolean result = valid();
		if(!result){
			setErroMessage(getPropertiesLoader().getValor("data_message"));
		}
		return result;
	}

	protected boolean valid() {
		boolean valid = true;
		String value = getValue().toString();
		GenericConverterField g = new GenericConverterField();
		try {
			g.convertField(Date.class, value);
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	}

}

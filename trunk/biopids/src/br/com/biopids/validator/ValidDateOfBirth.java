package br.com.biopids.validator;

import java.util.Date;

import org.apache.commons.collections.set.CompositeSet.SetMutator;

import br.com.biopids.converter.GenericConverterField;

public class ValidDateOfBirth extends AbstractValidator {
	
	@Override
	public boolean validate() {
		boolean result = true;
		try
		{
			Date date  = GenericConverterField.castDate(getValue().toString());
			result = date.getTime() < (new Date()).getTime();
		}catch (Exception e) {
			result = false;
		}
		if(!result)
			setErroMessage(getPropertiesLoader().getValor("data_nascimento_invalida"));
		return result;
		
	}

}

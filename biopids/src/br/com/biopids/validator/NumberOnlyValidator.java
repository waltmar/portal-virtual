package br.com.biopids.validator;

import org.apache.commons.collections.set.CompositeSet.SetMutator;

public class NumberOnlyValidator extends AbstractValidator {

	@Override
	public boolean validate() {
		String value = getValue().toString();
		boolean result = true;
		if((value != null) &&(!value.equalsIgnoreCase(""))){ 
		try{
			Integer.parseInt(value);
		}catch (Exception e) {
			result = false;
			setErroMessage(getPropertiesLoader().getValor("numberOnly_message"));
		}
		}
		return result;
	}

}

package br.com.biopids.validator;

public class EmailValidator extends AbstractValidator {

	
	@Override
	public boolean validate() {
		String value = getValue().toString();
		boolean result = value.contains("@");
		if(!result){
			setErroMessage(getPropertiesLoader().getValor("email_message"));
		}
		return result;
	}

}

package br.com.biopids.validator;

public class DateValidatorNotObr extends DateValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected boolean valid() {
		if (getValue().toString() == null)
			return true;
		 else  return super.valid();
		 
	}
}

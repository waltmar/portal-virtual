package br.com.biopids.validator;

public class NullValidator extends AbstractValidator{


	public NullValidator(IValidator next) {
		super(next);
	}
	
	public NullValidator(Object value){
		super(value);
	}

	@Override
	public boolean validate() {
		boolean result = this.getValue() == null;
		if(!result){
			setErroMessage(getPropertiesLoader().getValor("null_message"));
		}
		return result;
	}

}

package br.com.biopids.validator;

public class MaxLengthValidator extends AbstractValidator{

	private Integer max;
	public MaxLengthValidator(IValidator next, Integer max){
		super(next);
		this.max = max;
	}
	
	public MaxLengthValidator(Object value, Integer max){
		super(value);
		this.max = max;
	}
	
	@Override
	public boolean validate() {
		String value = getValue().toString();
		boolean result = value.length() > max;
		if (!result){
			setErroMessage(getMessage());
		}
		return result;
	}
	
	private String getMessage(){
		String message = getPropertiesLoader().getValor("max_length_message");
		return message.replaceAll("%max", max.toString());
	}
	
}

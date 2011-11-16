package br.com.biopids.validator;

import br.com.biopids.i8n.Marcador;
import br.com.biopids.util.PropertiesLoader;

public abstract class AbstractValidator implements IValidator{
	
	private String erroMessage;
	private IValidator validatorNext;
	private Object value;
	private PropertiesLoader propertiesLoader;
	
	public AbstractValidator(){
		propertiesLoader = new PropertiesLoader(Marcador.class, "commons_messages.properties");
	}
	
	public AbstractValidator(IValidator next){
		super();
		this.validatorNext = next;
		this.value = next.getValue();
	}
	
	public AbstractValidator(Object value){
		super();
		this.value = value;
	}
	
	public String getErroMessage(){
		return this.erroMessage;
	}
	
	public void setErroMessage(String erroMessage){
		this.erroMessage = erroMessage;
	}
	
	public IValidator getValidatorNext(){
		return this.validatorNext;
	}
	
	public void setValidatorNext(IValidator validator){
		this.validatorNext = validator;
	}
	
	public boolean isValide(){
		return validate() && chain();
	}
	
	protected boolean chain(){
		boolean valid = true;
		if(this.validatorNext != null){
			valid = this.validatorNext.isValide();
		}
		return valid;
	}
	
	public void concat(IValidator validator){
		if(this.validatorNext == null){
			this.validatorNext = validator;
		}else{
			this.validatorNext.concat(validator);
		}
	}
	
	
	public void setValue(Object value){
		this.value = value;
		if(this.validatorNext != null){
			this.validatorNext.setValue(value);
		}
	}
	
	public Object getValue(){
		return this.value;
	}
	

	
	public PropertiesLoader getPropertiesLoader() {
		return propertiesLoader;
	}

	public void setPropertiesLoader(PropertiesLoader propertiesLoader) {
		this.propertiesLoader = propertiesLoader;
	}

	public abstract boolean validate();
}

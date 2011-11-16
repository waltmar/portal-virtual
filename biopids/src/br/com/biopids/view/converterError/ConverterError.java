package br.com.biopids.view.converterError;


import java.io.Serializable;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.converter.GenericConverterEntity;
import br.com.biopids.converter.MappingField;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.exception.TypeErrors;
import br.com.biopids.exception.ValidateException;
import br.com.biopids.i8n.Marcador;
import br.com.biopids.util.PropertiesLoader;

public class ConverterError implements Serializable{
	
	private GenericConverterEntity genericConverterEntity;
	private ValidateException validateException;
	private StringBuilder message;
	private PropertiesLoader properties;
	private Object object;
	
	public ConverterError(GenericConverterEntity genericConverterEntity, ValidateException validateException, Object object){
		this.genericConverterEntity = genericConverterEntity;
		this.validateException = validateException;
		properties = new PropertiesLoader(Marcador.class, "commons_messages.properties");
		message = new StringBuilder();
		this.object = object;
	}
	
	public ErrorException converter(){
		
		for (MappingField mappingField : validateException.getFieldsWrong()) {
			MappingField mappingFieldModel = genericConverterEntity.getMappingFieldModel(mappingField);
			limparField(mappingFieldModel);
			setNameField(mappingFieldModel);
		}
		return finish();
	}
	
	private void limparField(MappingField mappingFieldModel) {
		try{
			mappingFieldModel.setValue(this.object, "");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private ErrorException finish(){
		String msg;
		msg = message.toString();
		msg = msg.substring(0,msg.length()-2);
		msg = getMessage(msg);
		return new ErrorException(TypeErrors.SEVERITY_ERROR, msg); 
	}
	
	private String getMessage(String fields){
		String message;
		if (validateException.getFieldsWrong().size() == 1)
			message = getMessageSingle(fields);
		else message = getMessagePlural(fields);
		return message;
	}
	

	
	private String getMessagePlural(String fields) {
		// TODO Auto-generated method stub
		String plural;
		plural = properties.getValor("MessageValidatorPlural");
		return plural.replaceAll("%campo", fields);
				
	}

	private String getMessageSingle(String fields) {
		// TODO Auto-generated method stub
		String single;
		single = properties.getValor("MessageValidatorSingle");
		return single.replaceAll("%campo", fields);
		
	}

	private void setNameField(MappingField mappingFieldModel) {
		// TODO Auto-generated method stub
		message.append(getNameField(mappingFieldModel));
		message.append(", ");
		
	}

	public String getNameField(MappingField mappingFieldModel){
		FieldBean fieldBean = (FieldBean) mappingFieldModel.getAnnotation(FieldBean.class);
		String name;
		if (fieldBean == null){
			name = mappingFieldModel.getNameField();
		} else {
			name = fieldBean.displayName(); 
		}
		return name;	
	}
	
	
	
	
}

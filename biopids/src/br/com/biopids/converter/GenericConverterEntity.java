package br.com.biopids.converter;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Service;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.exception.TypeErrors;
import br.com.biopids.interfaces.IConverterEntity;
import br.com.biopids.util.FactoreProperties;



@Service("GenericConverterEntity")
public class GenericConverterEntity implements IConverterEntity {

	private Object objectModel;
	private Object objectDomain;
	private Mapping mapping;
	private Collection<MappingFieldToField> list;
	private Collection<String> fieldsErros;
	

	public GenericConverterEntity() {
		mapping = Mapping.getInstance();
		this.fieldsErros = new ArrayList<String>();
		
		
	}

	private void mappingObject(Object objectModel, Object objectDomain)
			throws ErrorException {
		this.objectDomain = objectDomain;
		this.objectModel = objectModel;
		try {
			this.list = mapping.getListMappingFieldToField(this.objectModel.getClass(), this.objectDomain.getClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw getErrorCast();
		}
	}

	@Override
	public Object convertEntity(Object objectModel, Object objectDomain)
			throws ErrorException {
		mappingObject(objectModel, objectDomain);
		converter();
		if (!fieldsErros.isEmpty())
			throw getErrorException();
		return this.objectDomain;
	}

	@Override
	public Object reconvertEntity(Object classModel, Object classDomain)
			throws ErrorException{
		mappingObject(classModel, classDomain);
		try {
			reconvert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorException(TypeErrors.SEVERITY_ERROR, FactoreProperties.loadIn8().getValor("erroReconversao"));
		}
		return this.objectModel;
	}

	private ErrorException getErrorCast() {
		return new ErrorException(TypeErrors.SEVERITY_ERROR,
				"Erro ao converter campos!");
	}

	private ErrorException getErrorException() {
		return new ErrorException(TypeErrors.SEVERITY_ERROR, getErroFields());
	}

	private String getErroFields() {
		String aux = "";
		if(this.fieldsErros.size() == 1){
			aux = getErroFieldsSingle();
		}else{
			aux = getErroFieldsPlural();
		}
		return aux;
	}
	
	private String getNameFieldsWrong(){
		StringBuilder sb = new StringBuilder();
		for (String field : this.fieldsErros) {
			sb.append(field + ", ");
		}
		String aux = sb.toString();
		this.fieldsErros.clear();
		return aux.substring(0, aux.length() - 2);
	}
	
	private String getErroFieldsSingle(){
		String message = FactoreProperties.loadIn8().getValor("MessageValidatorSingle");
		message = message.replaceAll("%campo" , getNameFieldsWrong());
		return message;
	}
	
	private String getErroFieldsPlural(){
		String message = FactoreProperties.loadIn8().getValor("MessageValidatorPlural");
		message = message.replaceAll("%campo" ,getNameFieldsWrong());
		return message;
	}

	private void converter() {
		for (MappingFieldToField mappingFieldToField : list) {
			try {
				mappingFieldToField.setValueField1InField2(objectModel,
						objectDomain);
			} catch (Exception e) {
				mappingErrorCastField(mappingFieldToField);
			}
		}

	}

	private void reconvert() throws Exception {
		for (MappingFieldToField mappingFieldToField : list) {
			mappingFieldToField.setValueField2InField1(objectModel,
					objectDomain);
		}

	}

	private void mappingErrorCastField(MappingFieldToField mappingFieldToField) {
		MappingField fieldModel = mappingFieldToField.getField1();
		FieldBean fieldBean = (FieldBean) fieldModel
				.getAnnotation(FieldBean.class);
		String name = "";
		if (fieldBean != null) {
			name = fieldBean.displayName();
		}
		if (name.equalsIgnoreCase(""))
			name = fieldModel.getNameField();
		fieldsErros.add(name);
	}

	public MappingField getMappingFieldModel(MappingField mappingFieldDomain) {
		MappingField aux = null;
		for (MappingFieldToField mapping : this.list) {
			MappingField fieldDomain = mapping.getField2();
			if (mappingFieldDomain.equals(fieldDomain)) {
				aux = mapping.getField1();
				break;
			}
		}
		return aux;
	}

}

package br.com.biopids.validator;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.biopids.converter.ContainerMappingClass;
import br.com.biopids.converter.MappingClass;
import br.com.biopids.converter.MappingField;

@Service
public class ValidatorObject implements Serializable{
	private GenericValidatorFields genericValidatorFields;
	private Object object;
	private Collection<MappingField> mappingFields;
	
	public ValidatorObject(){}
	
	public ValidatorObject(Object object){
		setObject(object);
	}
	
	public boolean validate() throws Exception{
		genericValidatorFields = new GenericValidatorFields(this.mappingFields, this.object);
		return this.genericValidatorFields.validate();
	}
	
	private void findMappingFields(){
		ContainerMappingClass container = ContainerMappingClass.getInstance();
		MappingClass mappingClass = container.getMappingClass(this.object.getClass());
		this.mappingFields = mappingClass.getListMappingField();
	}

	public GenericValidatorFields getGenericValidatorFields() {
		return genericValidatorFields;
	}

	public void setGenericValidatorFields(
			GenericValidatorFields genericValidatorFields) {
		this.genericValidatorFields = genericValidatorFields;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
		findMappingFields();
	}

	public Collection<MappingField> getMappingFields() {
		return mappingFields;
	}

	public void setMappingFields(Collection<MappingField> mappingFields) {
		this.mappingFields = mappingFields;
	}
	
	public Collection<MappingField> getFieldsWrong(){
		return this.genericValidatorFields.getFieldsWrong();
	}
	
	
}

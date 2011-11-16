package br.com.biopids.validator;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.biopids.annotation.Validator;
import br.com.biopids.converter.MappingField;

public class GenericValidatorFields implements Serializable{
	
	private Collection<MappingField> fields;
	private Collection<MappingField> fieldsWrong; 
	private Object objectValidate;
	
	public GenericValidatorFields(Collection<MappingField> fields, Object objectValidate){
		this.fields = fields;
		this.fieldsWrong = new ArrayList<MappingField>();
		this.objectValidate = objectValidate;
	}
	
	public boolean validate() throws Exception{
		for (MappingField mappingField : fields) {
			if(!validateField(mappingField))
				fieldsWrong.add(mappingField);
		}
		return fieldsWrong.isEmpty();
	}
	
	private boolean validateField(MappingField mappingField) throws Exception{
		Validator validator = (Validator) mappingField.getAnnotation(Validator.class);
		boolean result = true;
		if(validator != null)
			result = executeValidate(validator,mappingField);
		return result;
	}
	

	private boolean executeValidate(Validator validator, MappingField mappingField) throws Exception{
		Class<?>[] classValidators = validator.validatorClass();
		boolean result = true;
		if(classValidators.length > 0)
			result = executeValidateClassValidators(classValidators, mappingField, validator.required());
		return result;
	}
	


	private boolean executeValidateClassValidators(Class<?>[] classValidators, MappingField mappingField, boolean required) throws Exception{
		IValidator validator = generateValidator(classValidators);
		Object value = mappingField.getValue(this.objectValidate);
		boolean result = true;
		if(value != null && !value.toString().equalsIgnoreCase("")){
			validator.setValue(value);
			result = validator.isValide();
		}else{
			result = !required;
		}
		
		return result;
	}

	private IValidator generateValidator(Class<?>[] classValidators) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		IValidator validator = (IValidator) classValidators[0].newInstance();
		for (int i = 1; i < classValidators.length; i++) {
			validator = createObjectValidator(classValidators[i], validator);
		}
		return validator;
	}
	

	private IValidator createObjectValidator(Class<?> classValidator, IValidator validator) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Constructor<?> constructor = classValidator.getConstructor(IValidator.class);
		return (IValidator) constructor.newInstance(validator);
	}

	public Object getObjectValidate() {
		return objectValidate;
	}

	public void setObjectValidate(Object objectValidate) {
		this.objectValidate = objectValidate;
	}

	public Collection<MappingField> getFields() {
		return fields;
	}

	public void setFields(Collection<MappingField> fields) {
		this.fields = fields;
	}

	public Collection<MappingField> getFieldsWrong() {
		return fieldsWrong;
	}

	public void setFieldsWrong(Collection<MappingField> fieldsWrong) {
		this.fieldsWrong = fieldsWrong;
	}
	
	
	
	
}

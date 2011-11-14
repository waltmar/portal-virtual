package br.com.biopids.converter;

import java.io.Serializable;

public class MappingFieldToField implements Serializable{

	

	private MappingField field1;
	private MappingField field2;

	public MappingFieldToField(MappingField field1, MappingField field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	public void setValueField1InField2(Object objectField1, Object objectField2) throws Exception{
		String value = (String) field1.getValue(objectField1);
		if ((value != null) && !value.equalsIgnoreCase("")) {
			Object object;
			try{
				object = castValue(field2.getClassType(), value);
			}catch (Exception e) {
				field1.setValue(objectField1, "");
				throw new Exception();
			}
			field2.setValue(objectField2, object);
		}
	}

	public void setValueField2InField1(Object objectField1, Object objectField2)
			throws Exception {
		Object value = field2.getValue(objectField2);
		if (value != null) {
			String object = recastValue(value);
			field1.setValue(objectField1, object);
		}
	}

	private Object castValue(Class<?> typeClass, String value) throws Exception {
		GenericConverterField converter = new GenericConverterField();
		return converter.convertField(typeClass, value);
	}

	private String recastValue(Object value) {
		GenericConverterField converter = new GenericConverterField();
		return converter.reconvertField(value);
	}
	public MappingField getField1() {
		return field1;
	}

	public void setField1(MappingField field1) {
		this.field1 = field1;
	}

	public MappingField getField2() {
		return field2;
	}

	public void setField2(MappingField field2) {
		this.field2 = field2;
	}

}

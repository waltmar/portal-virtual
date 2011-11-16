package br.com.biopids.converter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.biopids.annotation.NoAnotations;



public class MappingClass implements Serializable{
	
	private Class<?> classMapping;
	private Map<String, MappingField> listField;
	private boolean containsAnnotationsField;
	
	public MappingClass(Class<?> classMapping){
		setClassMapping(classMapping);
	}
	
	private MappingClass(Class<?> classMapping, boolean containsAnnotationField){
		this.classMapping = classMapping;
		this.containsAnnotationsField = containsAnnotationField;
	}
	
	private void mapping(){
		listField = new HashMap<String, MappingField>();
		Class<?> aux = this.classMapping;
		do{
			mappingClass(aux);
		}while((aux = aux.getSuperclass()) != null);
	}
	
	private void mappingClass(Class<?> classMapping){
		Field fields[] = classMapping.getDeclaredFields();
		for (Field field : fields) {
			if(!field.getName().equalsIgnoreCase("serialVersionUID"))
			listField.put(field.getName(), new MappingField(field, this.containsAnnotationsField, classMapping));
		}
	}
	
	protected void loadAnnotationsClass(){
		loadContainsAnnotationsField();
	}
	
	protected void loadContainsAnnotationsField(){
		NoAnotations noAnotations = this.classMapping.getAnnotation(NoAnotations.class);
		this.containsAnnotationsField = (noAnotations == null);
	}
	
	public Class<?> getClassMapping() {
		return classMapping;
	}
	
	public void setClassMapping(Class<?> classMapping) {
		this.classMapping = classMapping;
		loadAnnotationsClass();
		mapping();
	}
	
	public Collection<MappingField> getListMappingField(){
		return this.listField.values();
	}
	
	public MappingField getMappingFieldByNameField(String name){
		MappingField mappingField = null;
		if(this.listField.containsKey(name))
			mappingField = this.listField.get(name);
		return mappingField;
	}
	public void setListField(Map<String, MappingField> listField){
		this.listField = listField;
	}
	
	public MappingClass clone(){
		MappingClass mapping = new MappingClass(this.classMapping, this.containsAnnotationsField);
		mapping.setListField(cloneListField());
		return mapping;
	}
	
	public Map<String, MappingField> cloneListField(){
		Map<String, MappingField> list = new HashMap<String, MappingField>();
		for (String field : this.listField.keySet()) {
			list.put(field, this.listField.get(field).clone());
		}
		return list;
	}
	
	
	
}

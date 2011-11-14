package br.com.biopids.converter;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapping implements Serializable{
	
	private Map<Class<?>, Collection<MappingFieldToField>> mapping;
	private static Mapping instanceMapping;
	
	private Mapping(){
		mapping = new HashMap<Class<?>, Collection<MappingFieldToField>>();
	}
	
	public static Mapping getInstance(){
		if (instanceMapping == null)
			instanceMapping = new Mapping();
		return instanceMapping;
	}
	
	public Collection<MappingFieldToField> getListMappingFieldToField(Class<?> classKeyMapping, Class<?> classMapped) throws IllegalArgumentException, IllegalAccessException, Exception{
		if(!mapping.containsKey(classKeyMapping))
			mapping.put(classKeyMapping, mappingFieldsClass(classKeyMapping, classMapped));
		return mapping.get(classKeyMapping);
	}
	
	public Collection<MappingFieldToField> mappingFieldsClass(Class<?> classKeyMapping, Class<?> classMapped) throws IllegalArgumentException, IllegalAccessException, Exception{
		MappingModelToDomain mapping = new MappingModelToDomain(classKeyMapping, classMapped);
		return mapping.mapping();
	}
	
	
	
	

}

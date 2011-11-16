package br.com.biopids.converter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ContainerMappingClass implements Serializable{
	
	private static ContainerMappingClass classMapping;
	
	private Map<Class<?>, MappingClass> mapping;
	
	private ContainerMappingClass(){
		mapping = new HashMap<Class<?>, MappingClass>();
	}
	
	public static ContainerMappingClass getInstance(){
		if(classMapping == null)
				classMapping = new ContainerMappingClass();
		return classMapping; 
	}
	
	public MappingClass getMappingClass(Class<?> classMapping){
		if(! mapping.containsKey(classMapping))
			 newMapping(classMapping);
		return mapping.get(classMapping).clone();
	}
	
	private void newMapping(Class<?> classMapping){
		mapping.put(classMapping,new MappingClass(classMapping));
	}
	

}

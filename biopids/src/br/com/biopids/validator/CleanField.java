package br.com.biopids.validator;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.biopids.converter.ContainerMappingClass;
import br.com.biopids.converter.MappingClass;
import br.com.biopids.converter.MappingField;

@Service("CleanField")
public class CleanField implements Serializable{
	private MappingClass mappingClass;
	
	public void clean(Object object, String fieldDestination) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException{
		clearField(fieldDestination, object);
	}
	
	private void clearField(String fieldDestination, Object object) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException{
		this.mappingClass = ContainerMappingClass.getInstance().getMappingClass(object.getClass());
		if(!fieldDestination.contains(".")){
			this.mappingClass.getMappingFieldByNameField(fieldDestination).setValue(object, "");
		}else{
			int pos = fieldDestination.indexOf(".");
			MappingField mapping = this.mappingClass.getMappingFieldByNameField(fieldDestination.substring(0, pos));
			object = mapping.getValue(object);
			clearField(fieldDestination.substring(pos + 1, fieldDestination.length()), object);
		}
	}
}

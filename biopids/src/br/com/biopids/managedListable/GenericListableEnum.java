package br.com.biopids.managedListable;

import java.util.ArrayList;
import java.util.List;

import br.com.biopids.listable.AbstractGenericListable;

public class GenericListableEnum extends AbstractGenericListable<String>{

	private Class<?> enumClass;
	
	
	public GenericListableEnum(Class<?> enumClass){
		this.enumClass = enumClass;
		
	}
	
	@Override
	public List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (Object object: enumClass.getEnumConstants()) {
			list.add(object.toString()); 
		}
		return list;
	}
	
	@Override
	public boolean isOld(){
		return false;
	}
	
	
	
	
}

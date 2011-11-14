package br.com.biopids.listable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.biopids.interfaces.IListable;
import br.com.biopids.managedListable.GenericListableEnum;


@Scope(value="singleton")
@Service("ControlerList")
public class ControlerList implements Serializable{
	
	
	private HashMap<String, IListable<?>> mapping;
	
	public ControlerList(){
		mapping = new HashMap<String, IListable<?>>();
	}
	
	public List<?> getList(Class<?> classList){
		String nameClass = classList.getName();
		if(! mapping.containsKey(nameClass)){
			newMapping(classList);
		}
		return mapping.get(nameClass).getComboList();
	}
	
	private void newMapping(Class<?> classList){
		if(classList.isEnum()){
			mappingEnum(classList);
		}else{
			mappingClass(classList);
		}
	}

	private void mappingClass(Class<?> classList) {
		try{
			mapping.put(classList.getName(), (IListable) classList.newInstance());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void mappingEnum(Class<?> classList) {
		GenericListableEnum listable = new GenericListableEnum(classList);
		mapping.put(classList.getName(),listable);
		
	}
	

	
	
	
	
	
}

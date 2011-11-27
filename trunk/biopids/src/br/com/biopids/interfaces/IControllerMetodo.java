package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Metodo;
import br.com.biopids.exception.ErrorException;

public interface IControllerMetodo<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Metodo metodo, List<Metodo> list);  
	
	boolean isValid(Metodo metodo);
	
	boolean isNotNull(Metodo metodo);


}
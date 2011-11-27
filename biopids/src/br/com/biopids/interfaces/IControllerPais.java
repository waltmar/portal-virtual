package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Pais;
import br.com.biopids.domain.Reino;
import br.com.biopids.exception.ErrorException;

public interface IControllerPais<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Pais pais, List<Pais> list);
	
	boolean isValid(Pais pais);
	
	boolean isNotNull(Pais pais);
	
	boolean isFather(Pais pais) throws ErrorException;

}
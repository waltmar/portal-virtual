package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Estado;
import br.com.biopids.domain.Pais;
import br.com.biopids.exception.ErrorException;

public interface IControllerEstado<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Estado estado, List<Estado> list);
	
	boolean isValid(Estado estado);
	
	boolean isNotNull(Estado estado);
	
	boolean isFather(Estado estado) throws ErrorException;


}
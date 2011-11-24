package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Reino;
import br.com.biopids.exception.ErrorException;

public interface IControllerReino<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Reino reino, List<Reino> list);
	
	boolean isValid(Reino reino);
	
	boolean isNotNull(Reino reino);

	boolean isFather(Reino reino) throws ErrorException;
}
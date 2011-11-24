package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Filo;
import br.com.biopids.exception.ErrorException;

public interface IControllerFilo<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Filo Filo, List<Filo> list);
	
	boolean isValid(Filo Filo);
	
	boolean isNotNull(Filo Filo);

	boolean isFather(Filo Filo) throws ErrorException;
}
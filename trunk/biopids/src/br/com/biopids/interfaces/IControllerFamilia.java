package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Familia;
import br.com.biopids.exception.ErrorException;

public interface IControllerFamilia<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Familia familia, List<Familia> list);
	
	boolean isValid(Familia familia);
	
	boolean isNotNull(Familia familia);

	boolean isFather(Familia familia) throws ErrorException;
}
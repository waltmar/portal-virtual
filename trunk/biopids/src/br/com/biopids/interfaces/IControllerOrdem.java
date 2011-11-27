package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Ordem;
import br.com.biopids.exception.ErrorException;

public interface IControllerOrdem<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Ordem ordem, List<Ordem> list);
	
	boolean isValid(Ordem ordem);
	
	boolean isNotNull(Ordem ordem);

	boolean isFather(Ordem ordem) throws ErrorException;
}
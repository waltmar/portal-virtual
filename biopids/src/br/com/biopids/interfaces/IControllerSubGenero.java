package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.SubGenero;
import br.com.biopids.exception.ErrorException;

public interface IControllerSubGenero<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(SubGenero subGenero, List<SubGenero> list);
	
	boolean isValid(SubGenero subGenero);
	
	boolean isNotNull(SubGenero subGenero);

}
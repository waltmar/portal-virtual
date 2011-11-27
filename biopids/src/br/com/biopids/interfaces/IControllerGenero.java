package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Genero;
import br.com.biopids.exception.ErrorException;

public interface IControllerGenero<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Genero genero, List<Genero> list);
	
	boolean isValid(Genero genero);
	
	boolean isNotNull(Genero genero);

	boolean isFather(Genero genero) throws ErrorException;
}
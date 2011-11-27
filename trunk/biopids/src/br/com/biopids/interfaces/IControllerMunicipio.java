package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Municipio;
import br.com.biopids.domain.Pais;
import br.com.biopids.exception.ErrorException;

public interface IControllerMunicipio<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Municipio municipio, List<Municipio> list);
	
	boolean isValid(Municipio municipio);
	
	boolean isNotNull(Municipio municipio);

	boolean isFather(Municipio municipio) throws ErrorException;
}
package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Datum;
import br.com.biopids.exception.ErrorException;

public interface IControllerDatum<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Datum datum, List<Datum> list);
	
	boolean isValid(Datum datum);
	
	boolean isNotNull(Datum datum);


}
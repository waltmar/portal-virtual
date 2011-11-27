package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Fenologia;
import br.com.biopids.exception.ErrorException;

public interface IControllerFenologia<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Fenologia fenologia, List<Fenologia> list);
	
	boolean isValid(Fenologia fenologia);
	
	boolean isNotNull(Fenologia fenologia);


}
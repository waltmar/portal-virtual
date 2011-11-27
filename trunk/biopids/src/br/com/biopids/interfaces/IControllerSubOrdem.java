package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.SubOrdem;
import br.com.biopids.exception.ErrorException;

public interface IControllerSubOrdem<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(SubOrdem subOrdem, List<SubOrdem> list);
	
	boolean isValid(SubOrdem subOrdem);
	
	boolean isNotNull(SubOrdem subOrdem);

}
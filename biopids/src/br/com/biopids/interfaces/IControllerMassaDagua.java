package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.MassaDagua;
import br.com.biopids.exception.ErrorException;

public interface IControllerMassaDagua<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(MassaDagua massaDagua, List<MassaDagua> list);
	
	boolean isValid(MassaDagua massaDagua);
	
	boolean isNotNull(MassaDagua massaDagua);

	boolean isFather(MassaDagua massaDagua) throws ErrorException;
}
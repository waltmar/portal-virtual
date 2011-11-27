package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.EpEspecifico;
import br.com.biopids.exception.ErrorException;

public interface IControllerEpEspecifico<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(EpEspecifico epEspecifico, List<EpEspecifico> list);
	
	boolean isValid(EpEspecifico epEspecifico);
	
	boolean isNotNull(EpEspecifico epEspecifico);

}
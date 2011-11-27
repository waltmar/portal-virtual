package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.TipoMontagem;
import br.com.biopids.exception.ErrorException;

public interface IControllerTipoMontagem<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(TipoMontagem tipoMontagem, List<TipoMontagem> list);
	
	boolean isValid(TipoMontagem tipoMontagem);
	
	boolean isNotNull(TipoMontagem tipoMontagem);


}
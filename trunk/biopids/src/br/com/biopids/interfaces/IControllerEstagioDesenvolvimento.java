package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.EstagioDesenvolvimento;
import br.com.biopids.exception.ErrorException;

public interface IControllerEstagioDesenvolvimento<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(EstagioDesenvolvimento estagioDesenvolvimento, List<EstagioDesenvolvimento> list);
	
	boolean isValid(EstagioDesenvolvimento estagioDesenvolvimento);
	
	boolean isNotNull(EstagioDesenvolvimento estagioDesenvolvimento);

	
}
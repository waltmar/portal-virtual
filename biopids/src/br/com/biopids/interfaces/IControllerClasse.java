package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Classe;
import br.com.biopids.exception.ErrorException;

public interface IControllerClasse<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(Classe Classe, List<Classe> list);
	
	boolean isValid(Classe Classe);
	
	boolean isNotNull(Classe Classe);

	boolean isFather(Classe Classe) throws ErrorException;
}
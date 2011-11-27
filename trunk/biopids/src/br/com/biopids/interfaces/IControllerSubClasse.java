package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.SubClasse;
import br.com.biopids.exception.ErrorException;

public interface IControllerSubClasse<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(SubClasse subClasse, List<SubClasse> list);
	
	boolean isValid(SubClasse subClasse);
	
	boolean isNotNull(SubClasse subClasse);

}
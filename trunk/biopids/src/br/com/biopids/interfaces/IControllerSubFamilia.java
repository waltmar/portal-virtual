package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.SubFamilia;
import br.com.biopids.exception.ErrorException;

public interface IControllerSubFamilia<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isNew(SubFamilia subFamilia, List<SubFamilia> list);
	
	boolean isValid(SubFamilia subFamilia);
	
	boolean isNotNull(SubFamilia subFamilia);

}
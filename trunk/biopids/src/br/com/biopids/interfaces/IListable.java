package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IListable <T extends Object> extends Serializable{
	
	List<T> getComboList();
	boolean isOld();
	
	
}

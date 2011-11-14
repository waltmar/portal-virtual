package br.com.biopids.interfaces;


import java.io.Serializable;
import java.util.List;

import br.com.biopids.exception.ErrorException;

public interface IController<T extends Serializable, oid extends Serializable> extends Serializable{
	
	public void save(T entity) throws ErrorException;
	public void delete(T entity) throws ErrorException;
	public void update (T entity)throws ErrorException;
	T getById(T entity,oid id) throws ErrorException;
	List<T> getAll(T entity) throws ErrorException;
	List<T> getByFinger(T entity) throws ErrorException;
	List<T> getByFinder(T entity, String ...columns) throws ErrorException;
	List<T> getByFinder(T entity, String[] orders, String ...columns) throws ErrorException;
}
	


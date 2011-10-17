package br.com.scbio.interfaces;


import java.io.Serializable;
import java.util.List;

import br.com.scbio.exception.ErrorException;


public interface IController<T extends Serializable, oid extends Serializable>{

	public void save(T entity) throws ErrorException;
	public void delete(T entity) throws ErrorException;
	public void update (T entity)throws ErrorException;
	public T getById(T entity,oid id) throws ErrorException;
	public List<T> getAll(T entity) throws ErrorException;
	public List<T> getByFinger(T entity) throws ErrorException;
	public List<T> getByFinder(T entity, String ...fields) throws ErrorException;
	
}
	


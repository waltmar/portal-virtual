package br.com.scbio.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.scbio.exception.ErrorException;



public interface IManagedBean<T extends Serializable, oid extends Serializable>{
	
	public void save() throws ErrorException;
	public void delete() throws ErrorException;
	public void update ()throws ErrorException;
	public T getById(oid id) throws ErrorException;
	public List<T> getAll() throws ErrorException;
	public T getByFinger(T entity) throws ErrorException;
	
}

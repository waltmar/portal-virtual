package br.com.biopids.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.exception.ErrorException;
import br.com.biopids.exception.TypeErrors;
import br.com.biopids.exception.ValidateException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.persistence.GenericSearch;
import br.com.biopids.util.FactoreProperties;
import br.com.biopids.util.PropertiesLoader;
import br.com.biopids.validator.GenericValidatorFields;
import br.com.biopids.validator.ValidatorObject;


public abstract class GenericController<T extends Serializable,oid extends Serializable> implements IController<T, oid>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericDAO<T, oid> dao;
	@Autowired(required=true)
	private ValidatorObject validator;
	protected PropertiesLoader properties;
	
	public GenericController(){
		properties = getPropertiesLoader();
	}
	
	

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(T entity) throws ErrorException {
		// TODO Auto-generated method stub
		if (beforeSave()){
			checkValidate(entity);
			actionSave(entity);
			afterSave();
		} 
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly=false)
	public void delete(T entity) throws ErrorException {
		// TODO Auto-generated method stub
		if (beforeDelete()){
			actionDelete(entity);
			afterDelete();
		} 
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly=false)
	public void update(T entity) throws ErrorException {
		// TODO Auto-generated method stub
		if (beforeUpdate()){
			actionUpdate(entity);
			afterUpdate();
		}
		
	}
	
	@Override
	public T getById(T entity, oid id) throws ErrorException {
		// TODO Auto-generated method stub
		
		if (beforeGetById()){
			entity = actionGetById(entity, id);
			afterDelete();
		}
		return entity;
	}


	@Override
	public List<T> getAll(T entity) throws ErrorException {
		// TODO Auto-generated method stub
		List<T> list= new ArrayList<T>();
		if (beforeGetAll()){
			list = actionGetAll(entity); 
			
		}
		return list;
	}


	@Override
	public List<T> getByFinger(T entity) throws ErrorException {
		return null;
		
	}
	
	public List<T> getByFinder(T entity, String ...collumns)throws ErrorException{
		List<T> list = null;
		list = dao.getByFinder(entity, collumns);
		return list;
	}
	
	public List<T> getByFinder(T entity, String[] orders, String ...collumns) throws ErrorException{
		List<T> list = null;
		list = dao.getByFinder(entity, orders, collumns);
		return list;
	}
	
	public boolean validate(T entity) throws Exception{
		  validator.setObject(entity);
		  return validator.validate();
	}
	
	public void checkValidate(T entity) throws ErrorException{
		boolean result = true;
		try{
			result = validate(entity);
		}catch (Exception e) {
			throw new ErrorException(TypeErrors.SEVERITY_ERROR, "Erro ao validar campos!");
		}
		if(!result){
			throw new ValidateException(validator.getFieldsWrong());
		}
			
		
	}
	
	
	
	public void actionSave(T entity){
		dao.save(entity);
	}
	  
	public boolean beforeSave(){
		return true;
	}
	public void afterSave(){}
	
	public boolean beforeDelete(){	
		return true;
	}
	public void afterDelete(){}
	
	
	public void actionDelete(T entity){
		dao.delete(entity);
	}
	
	public boolean beforeUpdate(){	
		return true;
	}
	public void afterUpdate(){}
	
	public void actionUpdate(T entity){
		dao.update(entity);
	}
	
	public boolean beforeGetById(){	
		return true;
	}
	public void afterGetById(){}
	
	public T actionGetById(T entity, oid id){
		return dao.getByID(entity, id);
	}
	
	public boolean beforeGetAll(){	
		return true;
	}
	public void afterGetAll(){}
	
	public List<T> actionGetAll(T entity){
		return dao.getAll(entity);
	}
	
	public boolean beforeGetByFinger(){	
		return true;
	}
	
	public void afterGetByFinger(){}
	
	@PostConstruct
	public void setDAOInControler(){
		this.dao = getDAO();
	}
	
	
	
	public ValidatorObject getValidator() {
		return validator;
	}

	public void setValidator(ValidatorObject validator) {
		this.validator = validator;
	}
	
	protected PropertiesLoader getPropertiesLoader() {
		// TODO Auto-generated method stub
		return FactoreProperties.loadIn8();
	}

	public abstract GenericDAO<T, oid> getDAO();
	
}

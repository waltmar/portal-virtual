package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Metodo;
import br.com.biopids.persistence.DAOMetodo;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerMetodo")
public class ControllerMetodo extends GenericController<Metodo, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerMetodo(){
		super();
	}
	
	@Autowired(required=true)
	private DAOMetodo daoMetodo;
	
	
	@Override
	public GenericDAO<Metodo, Long> getDAO() {
		return this.daoMetodo;
	}

	public DAOMetodo getDaoMetodo() {
		return daoMetodo;
	}

	public void setDaoMetodo(DAOMetodo daoMetodo) {
		this.daoMetodo = daoMetodo;
	}
	
}

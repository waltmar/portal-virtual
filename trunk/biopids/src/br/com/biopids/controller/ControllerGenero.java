package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Genero;
import br.com.biopids.persistence.DAOGenero;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerGenero")
public class ControllerGenero extends GenericController<Genero, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerGenero(){
		super();
	}
	
	@Autowired(required=true)
	private DAOGenero daoGenero;
	
	
	@Override
	public GenericDAO<Genero, Long> getDAO() {
		return this.daoGenero;
	}

	public DAOGenero getDaoGenero() {
		return daoGenero;
	}

	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}
	
}

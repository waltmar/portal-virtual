package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.SubGenero;
import br.com.biopids.persistence.DAOSubGenero;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerSubGenero")
public class ControllerSubGenero extends GenericController<SubGenero, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerSubGenero(){
		super();
	}
	
	@Autowired(required=true)
	private DAOSubGenero daoSubGenero;
	
	
	@Override
	public GenericDAO<SubGenero, Long> getDAO() {
		return this.daoSubGenero;
	}

	public DAOSubGenero getDaoSubGenero() {
		return daoSubGenero;
	}

	public void setDaoSubGenero(DAOSubGenero daoSubGenero) {
		this.daoSubGenero = daoSubGenero;
	}
	
}

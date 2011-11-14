package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Alinea;
import br.com.biopids.persistence.DAOAlinea;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerAlinea")
public class ControllerAlinea extends GenericController<Alinea, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOAlinea daoAlinea;
	
	
	public ControllerAlinea(){
		super();
	}
	
	
	
	@Override
	public GenericDAO<Alinea, Long> getDAO() {
		return this.daoAlinea;
	}

	public DAOAlinea getDaoAlinea() {
		return daoAlinea;
	}

	public void setDaoAlinea(DAOAlinea daoAlinea) {
		this.daoAlinea = daoAlinea;
	}
	
}

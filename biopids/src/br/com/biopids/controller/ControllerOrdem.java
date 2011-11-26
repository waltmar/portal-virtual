package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Ordem;
import br.com.biopids.persistence.DAOOrdem;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerOrdem")
public class ControllerOrdem extends GenericController<Ordem, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerOrdem(){
		super();
	}
	
	@Autowired(required=true)
	private DAOOrdem daoOrdem;
	
	
	@Override
	public GenericDAO<Ordem, Long> getDAO() {
		return this.daoOrdem;
	}

	public DAOOrdem getDaoOrdem() {
		return daoOrdem;
	}

	public void setDaoOrdem(DAOOrdem daoOrdem) {
		this.daoOrdem = daoOrdem;
	}
	
}

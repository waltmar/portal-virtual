package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Familia;
import br.com.biopids.persistence.DAOFamilia;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerFamilia")
public class ControllerFamilia extends GenericController<Familia, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerFamilia(){
		super();
	}
	
	@Autowired(required=true)
	private DAOFamilia daoFamilia;
	
	
	@Override
	public GenericDAO<Familia, Long> getDAO() {
		return this.daoFamilia;
	}

	public DAOFamilia getDaoFamilia() {
		return daoFamilia;
	}

	public void setDaoFamilia(DAOFamilia daoFamilia) {
		this.daoFamilia = daoFamilia;
	}
	
}

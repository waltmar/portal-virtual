package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.SubFamilia;
import br.com.biopids.persistence.DAOSubFamilia;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerSubFamilia")
public class ControllerSubFamilia extends GenericController<SubFamilia, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerSubFamilia(){
		super();
	}
	
	@Autowired(required=true)
	private DAOSubFamilia daoSubFamilia;
	
	
	@Override
	public GenericDAO<SubFamilia, Long> getDAO() {
		return this.daoSubFamilia;
	}

	public DAOSubFamilia getDaoSubFamilia() {
		return daoSubFamilia;
	}

	public void setDaoSubFamilia(DAOSubFamilia daoSubFamilia) {
		this.daoSubFamilia = daoSubFamilia;
	}
	
}

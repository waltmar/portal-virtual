package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Especime;
import br.com.biopids.persistence.DAOEspecime;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerEspecime")
public class ControllerEspecime extends GenericController<Especime, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOEspecime daoEspecime;
	
	
	public ControllerEspecime(){
		super();
	}
	
	@Override
	public GenericDAO<Especime, Long> getDAO() {
		return this.daoEspecime;
	}

	public DAOEspecime getDaoEspecime() {
		return daoEspecime;
	}

	public void setDaoEspecime(DAOEspecime daoEspecime) {
		this.daoEspecime = daoEspecime;
	}
	
}

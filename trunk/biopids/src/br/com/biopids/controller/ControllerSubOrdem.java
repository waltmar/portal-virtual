package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.SubOrdem;
import br.com.biopids.persistence.DAOSubOrdem;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerSubOrdem")
public class ControllerSubOrdem extends GenericController<SubOrdem, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerSubOrdem(){
		super();
	}
	
	@Autowired(required=true)
	private DAOSubOrdem daoSubOrdem;
	
	
	@Override
	public GenericDAO<SubOrdem, Long> getDAO() {
		return this.daoSubOrdem;
	}

	public DAOSubOrdem getDaoSubOrdem() {
		return daoSubOrdem;
	}

	public void setDaoSubOrdem(DAOSubOrdem daoSubOrdem) {
		this.daoSubOrdem = daoSubOrdem;
	}
	
}

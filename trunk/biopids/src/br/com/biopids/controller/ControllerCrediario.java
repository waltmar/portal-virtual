package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Crediario;
import br.com.biopids.persistence.DAOCrediario;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerCrediario")
public class ControllerCrediario extends GenericController<Crediario, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerCrediario(){
		super();
	}
	
	@Autowired(required=true)
	private DAOCrediario daoCrediario;
	
	
	@Override
	public GenericDAO<Crediario, Long> getDAO() {
		return this.daoCrediario;
	}

	public DAOCrediario getDaoCrediario() {
		return daoCrediario;
	}

	public void setDaoCrediario(DAOCrediario daoCrediario) {
		this.daoCrediario = daoCrediario;
	}
	
}

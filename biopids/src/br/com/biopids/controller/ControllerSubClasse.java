package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.SubClasse;
import br.com.biopids.persistence.DAOSubClasse;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerSubClasse")
public class ControllerSubClasse extends GenericController<SubClasse, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerSubClasse(){
		super();
	}
	
	@Autowired(required=true)
	private DAOSubClasse daoSubClasse;
	
	
	@Override
	public GenericDAO<SubClasse, Long> getDAO() {
		return this.daoSubClasse;
	}

	public DAOSubClasse getDaoSubClasse() {
		return daoSubClasse;
	}

	public void setDaoSubClasse(DAOSubClasse daoSubClasse) {
		this.daoSubClasse = daoSubClasse;
	}
	
}

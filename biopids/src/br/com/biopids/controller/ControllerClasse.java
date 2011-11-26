package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Classe;
import br.com.biopids.persistence.DAOClasse;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerClasse")
public class ControllerClasse extends GenericController<Classe, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerClasse(){
		super();
	}
	
	@Autowired(required=true)
	private DAOClasse daoClasse;
	
	
	@Override
	public GenericDAO<Classe, Long> getDAO() {
		return this.daoClasse;
	}

	public DAOClasse getDaoClasse() {
		return daoClasse;
	}

	public void setDaoClasse(DAOClasse daoClasse) {
		this.daoClasse = daoClasse;
	}
	
}

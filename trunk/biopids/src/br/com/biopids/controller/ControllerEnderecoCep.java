package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.EnderecoCep;
import br.com.biopids.persistence.DAOEnderecoCep;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerEnderecoCep")
public class ControllerEnderecoCep extends GenericController<EnderecoCep, Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerEnderecoCep(){
		super();
	}
	
	@Autowired(required=true)
	private DAOEnderecoCep daoEnderecoCep;
	
	
	@Override
	public GenericDAO<EnderecoCep, Integer> getDAO() {
		return this.daoEnderecoCep;
	}

	public DAOEnderecoCep getDaoEnderecoCep() {
		return daoEnderecoCep;
	}

	public void setDaoEnderecoCep(DAOEnderecoCep daoEnderecoCep) {
		this.daoEnderecoCep = daoEnderecoCep;
	}
	
}

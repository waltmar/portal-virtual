package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Estado;
import br.com.biopids.persistence.DAOEstado;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerEstado")
public class ControllerEstado extends GenericController<Estado, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOEstado daoEstado;
	
	
	public ControllerEstado(){
		super();
	}
	
	@Override
	public GenericDAO<Estado, Long> getDAO() {
		return this.daoEstado;
	}

	public DAOEstado getDaoEstado() {
		return daoEstado;
	}

	public void setDaoEstado(DAOEstado daoEstado) {
		this.daoEstado = daoEstado;
	}
	
}

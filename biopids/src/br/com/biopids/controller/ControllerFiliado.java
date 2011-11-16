package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Filiado;
import br.com.biopids.persistence.DAOFiliado;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerFiliado")
public class ControllerFiliado extends GenericController<Filiado, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOFiliado daoFiliado;
	
	
	public ControllerFiliado(){
		super();
	}
	
	
	
	@Override
	public GenericDAO<Filiado, Long> getDAO() {
		return this.daoFiliado;
	}

	public DAOFiliado getDaoFiliado() {
		return daoFiliado;
	}

	public void setDaoFiliado(DAOFiliado daoFiliado) {
		this.daoFiliado = daoFiliado;
	}
	
}

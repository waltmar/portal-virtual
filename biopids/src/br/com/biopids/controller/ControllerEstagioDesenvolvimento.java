package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.EstagioDesenvolvimento;
import br.com.biopids.persistence.DAOEstagioDesenvolvimento;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerEstagioDesenvolvimento")
public class ControllerEstagioDesenvolvimento extends GenericController<EstagioDesenvolvimento, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerEstagioDesenvolvimento(){
		super();
	}
	
	@Autowired(required=true)
	private DAOEstagioDesenvolvimento daoEstagioDesenvolvimento;
	
	
	@Override
	public GenericDAO<EstagioDesenvolvimento, Long> getDAO() {
		return this.daoEstagioDesenvolvimento;
	}

	public DAOEstagioDesenvolvimento getDaoEstagioDesenvolvimento() {
		return daoEstagioDesenvolvimento;
	}

	public void setDaoEstagioDesenvolvimento(DAOEstagioDesenvolvimento daoEstagioDesenvolvimento) {
		this.daoEstagioDesenvolvimento = daoEstagioDesenvolvimento;
	}
	
}

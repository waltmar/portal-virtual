package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.biopids.domain.Autor;
import br.com.biopids.persistence.DAOAutor;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerAutor")
public class ControllerAutor extends GenericController<Autor, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerAutor(){
		super();
	}
	
	@Autowired(required=true)
	private DAOAutor daoAutor;
	
	
	@Override
	public GenericDAO<Autor, Long> getDAO() {
		return this.daoAutor;
	}

	public DAOAutor getDaoAutor() {
		return daoAutor;
	}

	public void setDaoAutor(DAOAutor daoAutor) {
		this.daoAutor = daoAutor;
	}
	
}

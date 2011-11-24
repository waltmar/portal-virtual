package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Pais;
import br.com.biopids.persistence.DAOPais;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerPais")
public class ControllerPais extends GenericController<Pais, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOPais daoPais;
	
	
	public ControllerPais(){
		super();
	}
	
	@Override
	public GenericDAO<Pais, Long> getDAO() {
		return this.daoPais;
	}

	public DAOPais getDaoPais() {
		return daoPais;
	}

	public void setDaoPais(DAOPais daoPais) {
		this.daoPais = daoPais;
	}
	
}

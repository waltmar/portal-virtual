package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Municipio;
import br.com.biopids.persistence.DAOMunicipio;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerMunicipio")
public class ControllerMunicipio extends GenericController<Municipio, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOMunicipio daoMunicipio;
	
	
	public ControllerMunicipio(){
		super();
	}
	
	@Override
	public GenericDAO<Municipio, Long> getDAO() {
		return this.daoMunicipio;
	}

	public DAOMunicipio getDaoMunicipio() {
		return daoMunicipio;
	}

	public void setDaoMunicipio(DAOMunicipio daoMunicipio) {
		this.daoMunicipio = daoMunicipio;
	}
	
}

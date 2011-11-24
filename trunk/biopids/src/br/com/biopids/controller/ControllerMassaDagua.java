package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.MassaDagua;
import br.com.biopids.persistence.DAOMassaDagua;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerMassaDagua")
public class ControllerMassaDagua extends GenericController<MassaDagua, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOMassaDagua daoMassaDagua;
	
	
	public ControllerMassaDagua(){
		super();
	}
	
	@Override
	public GenericDAO<MassaDagua, Long> getDAO() {
		return this.daoMassaDagua;
	}

	public DAOMassaDagua getDaoMassaDagua() {
		return daoMassaDagua;
	}

	public void setDaoMassaDagua(DAOMassaDagua daoMassaDagua) {
		this.daoMassaDagua = daoMassaDagua;
	}
	
}

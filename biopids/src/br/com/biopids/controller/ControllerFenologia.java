package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Fenologia;
import br.com.biopids.persistence.DAOFenologia;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerFenologia")
public class ControllerFenologia extends GenericController<Fenologia, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerFenologia(){
		super();
	}
	
	@Autowired(required=true)
	private DAOFenologia daoFenologia;
	
	
	@Override
	public GenericDAO<Fenologia, Long> getDAO() {
		return this.daoFenologia;
	}

	public DAOFenologia getDaoFenologia() {
		return daoFenologia;
	}

	public void setDaoFenologia(DAOFenologia daoFenologia) {
		this.daoFenologia = daoFenologia;
	}
	
}

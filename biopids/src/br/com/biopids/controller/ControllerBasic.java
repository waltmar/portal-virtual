package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Basic;
import br.com.biopids.persistence.DAOBasic;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerBasic")
public class ControllerBasic extends GenericController<Basic, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerBasic(){
		super();
	}
	
	@Autowired(required=true)
	private DAOBasic daoBasic;
	
	
	@Override
	public GenericDAO<Basic, Long> getDAO() {
		return this.daoBasic;
	}

	public DAOBasic getDaoBasic() {
		return daoBasic;
	}

	public void setDaoBasic(DAOBasic daoBasic) {
		this.daoBasic = daoBasic;
	}
	
}

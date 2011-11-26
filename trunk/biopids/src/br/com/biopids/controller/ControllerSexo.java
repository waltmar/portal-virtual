package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Sexo;
import br.com.biopids.persistence.DAOSexo;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerSexo")
public class ControllerSexo extends GenericController<Sexo, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerSexo(){
		super();
	}
	
	@Autowired(required=true)
	private DAOSexo daoSexo;
	
	
	@Override
	public GenericDAO<Sexo, Long> getDAO() {
		return this.daoSexo;
	}

	public DAOSexo getDaoSexo() {
		return daoSexo;
	}

	public void setDaoSexo(DAOSexo daoSexo) {
		this.daoSexo = daoSexo;
	}
	
}

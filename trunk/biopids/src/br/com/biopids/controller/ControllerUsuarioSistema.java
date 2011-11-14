package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.UsuarioSistema;
import br.com.biopids.persistence.DAOUsuarioSistema;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerUsuarioSistema")
public class ControllerUsuarioSistema extends GenericController<UsuarioSistema, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerUsuarioSistema(){
		super();
	}
	
	@Autowired(required=true)
	private DAOUsuarioSistema daoUsuarioSistema;
	
	
	@Override
	public GenericDAO<UsuarioSistema, Long> getDAO() {
		return this.daoUsuarioSistema;
	}

	public DAOUsuarioSistema getDaoUsuarioSistema() {
		return daoUsuarioSistema;
	}

	public void setDaoUsuarioSistema(DAOUsuarioSistema daoUsuarioSistema) {
		this.daoUsuarioSistema = daoUsuarioSistema;
	}
	
}

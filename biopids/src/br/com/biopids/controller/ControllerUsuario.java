package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Usuario;
import br.com.biopids.persistence.DAOUsuario;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerUsuario")
public class ControllerUsuario extends GenericController<Usuario, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerUsuario(){
		super();
	}
	
	@Autowired(required=true)
	private DAOUsuario daoUsuario;
	
	
	@Override
	public GenericDAO<Usuario, Long> getDAO() {
		return this.daoUsuario;
	}

	public DAOUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
}

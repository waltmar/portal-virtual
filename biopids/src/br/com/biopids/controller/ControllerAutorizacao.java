package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.biopids.domain.Autorizacao;
import br.com.biopids.persistence.DAOAutorizacao;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerAutorizacao")
public class ControllerAutorizacao extends GenericController<Autorizacao, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerAutorizacao(){
		super();
	}
	
	@Autowired(required=true)
	private DAOAutorizacao daoAutorizacao;
	
	
	@Override
	public GenericDAO<Autorizacao, Long> getDAO() {
		return this.daoAutorizacao;
	}

	public DAOAutorizacao getDaoAutorizacao() {
		return daoAutorizacao;
	}

	public void setDaoAutorizacao(DAOAutorizacao daoAutorizacao) {
		this.daoAutorizacao = daoAutorizacao;
	}
	
}

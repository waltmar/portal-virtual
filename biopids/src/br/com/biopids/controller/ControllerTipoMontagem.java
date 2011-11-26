package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.TipoMontagem;
import br.com.biopids.persistence.DAOTipoMontagem;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerTipoMontagem")
public class ControllerTipoMontagem extends GenericController<TipoMontagem, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerTipoMontagem(){
		super();
	}
	
	@Autowired(required=true)
	private DAOTipoMontagem daoTipoMontagem;
	
	
	@Override
	public GenericDAO<TipoMontagem, Long> getDAO() {
		return this.daoTipoMontagem;
	}

	public DAOTipoMontagem getDaoTipoMontagem() {
		return daoTipoMontagem;
	}

	public void setDaoTipoMontagem(DAOTipoMontagem daoTipoMontagem) {
		this.daoTipoMontagem = daoTipoMontagem;
	}
	
}

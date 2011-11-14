package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.PessoaJuridica;
import br.com.biopids.persistence.DAOPessoaJuridica;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerPessoaJuridica")
public class ControllerPessoaJuridica extends GenericController<PessoaJuridica, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerPessoaJuridica(){
		super();
	}
	
	@Autowired(required=true)
	private DAOPessoaJuridica daoPessoaJuridica;
	
	
	@Override
	public GenericDAO<PessoaJuridica, Long> getDAO() {
		return this.daoPessoaJuridica;
	}

	public DAOPessoaJuridica getDaoPessoaJuridica() {
		return daoPessoaJuridica;
	}

	public void setDaoPessoaJuridica(DAOPessoaJuridica daoPessoaJuridica) {
		this.daoPessoaJuridica = daoPessoaJuridica;
	}
	
}

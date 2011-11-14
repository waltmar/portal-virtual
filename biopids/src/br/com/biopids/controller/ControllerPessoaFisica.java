package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.persistence.Criteria;
import br.com.biopids.persistence.DAOPessoaFisica;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.persistence.GenericSearch;

@Service("ControllerPessoaFisica")
public class ControllerPessoaFisica extends GenericController<PessoaFisica, Long> {
	
	/**
	 * 
	 */
	private GenericSearch genericSearch;
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerPessoaFisica(){
		super();
	}
	
	@Autowired(required=true)
	private DAOPessoaFisica daoPessoaFisica;
	

	
	@Override
	public GenericDAO<PessoaFisica, Long> getDAO() {
		return this.daoPessoaFisica;
	}
	

	public DAOPessoaFisica getDaoPessoaFisica() {
		return daoPessoaFisica;
	}

	public void setDaoPessoaFisica(DAOPessoaFisica daoPessoaFisica) {
		this.daoPessoaFisica = daoPessoaFisica;
	}
	
}

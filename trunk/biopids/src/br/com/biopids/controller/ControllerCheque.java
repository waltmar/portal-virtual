package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Cheque;
import br.com.biopids.persistence.DAOCheque;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerCheque")
public class ControllerCheque extends GenericController<Cheque, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOCheque daoCheque;
	
	
	public ControllerCheque(){
		super();
	}
	
	@Override
	public GenericDAO<Cheque, Long> getDAO() {
		return this.daoCheque;
	}

	public DAOCheque getDaoCheque() {
		return daoCheque;
	}

	public void setDaoCheque(DAOCheque daoCheque) {
		this.daoCheque = daoCheque;
	}
	
}

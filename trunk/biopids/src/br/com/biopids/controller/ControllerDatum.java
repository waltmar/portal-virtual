package br.com.biopids.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Datum;
import br.com.biopids.persistence.DAODatum;
import br.com.biopids.persistence.GenericDAO;

@Service("ControllerDatum")
public class ControllerDatum extends GenericController<Datum, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAODatum daoDatum;
	
	
	public ControllerDatum(){
		super();
	}
	
	@Override
	public GenericDAO<Datum, Long> getDAO() {
		return this.daoDatum;
	}

	public DAODatum getDaoDatum() {
		return daoDatum;
	}

	public void setDaoDatum(DAODatum daoDatum) {
		this.daoDatum = daoDatum;
	}
	
}

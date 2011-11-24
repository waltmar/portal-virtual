package br.com.biopids.persistence;

import org.springframework.stereotype.Repository;

import br.com.biopids.domain.Filo;

@Repository("daoFilo")
public class DAOFilo extends GenericDAO<Filo, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

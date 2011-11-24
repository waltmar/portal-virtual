package br.com.biopids.persistence;

import org.springframework.stereotype.Repository;

import br.com.biopids.domain.Datum;

@Repository("daoDatum")
public class DAODatum extends GenericDAO<Datum, Long>{



}

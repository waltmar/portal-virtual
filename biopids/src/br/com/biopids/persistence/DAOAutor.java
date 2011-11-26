package br.com.biopids.persistence;

import org.springframework.stereotype.Repository;

import br.com.biopids.domain.Autor;

@Repository("daoAutor")
public class DAOAutor extends GenericDAO<Autor, Long>{



}
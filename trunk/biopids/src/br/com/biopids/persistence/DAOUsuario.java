package br.com.biopids.persistence;

import org.springframework.stereotype.Repository;

import br.com.biopids.domain.Usuario;

@Repository("daoUsuario")
public class DAOUsuario extends GenericDAO<Usuario, Long>{



}


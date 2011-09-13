package br.com.scbio.domain;

import java.io.Serializable;


public class EntityPersist implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
}

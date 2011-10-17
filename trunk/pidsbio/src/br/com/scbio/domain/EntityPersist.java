package br.com.scbio.domain;

import java.io.Serializable;

public class EntityPersist implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id_item;

	public Long getId_item() {
		return id_item;
	}

	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

}

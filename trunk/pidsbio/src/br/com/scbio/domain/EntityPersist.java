package br.com.scbio.domain;

import java.io.Serializable;

public class EntityPersist implements Serializable {

	private static final long serialVersionUID = 1L;

	private float id_item;

	public float getId_item() {
		return id_item;
	}

	public void setId_item(float id_item) {
		this.id_item = id_item;
	}

}

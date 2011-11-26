package br.com.biopids.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="genero")
public class Genero extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade={ CascadeType.ALL ,CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private Familia Familia;
	private String valor;
	
	public Genero(){
	}
	
	public Familia getFamilia() {
		return Familia;
	}

	public void setFamilia(Familia Familia) {
		this.Familia = Familia;
	}

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}


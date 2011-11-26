package br.com.biopids.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="sub_ordem")
public class SubOrdem extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade={ CascadeType.ALL ,CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private Ordem Ordem;
	private String valor;
	
	public SubOrdem(){
	}
	
	public Ordem getOrdem() {
		return Ordem;
	}

	public void setOrdem(Ordem Ordem) {
		this.Ordem = Ordem;
	}

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}


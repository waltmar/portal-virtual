package br.com.biopids.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="sub_classe")
public class SubClasse extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade={ CascadeType.ALL ,CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private Classe Classe;
	private String valor;
	
	public SubClasse(){
	}
	
	public Classe getClasse() {
		return Classe;
	}

	public void setClasse(Classe Classe) {
		this.Classe = Classe;
	}

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}


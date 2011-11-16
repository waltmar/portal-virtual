package br.com.biopids.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

 
@Entity
@Table(name="autorizacao")
public class Autorizacao extends EntityPersist{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String nome;
 
    public Autorizacao() {
    	
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    
 
    //getter and setter
 
}
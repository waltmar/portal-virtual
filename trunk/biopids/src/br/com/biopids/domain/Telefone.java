/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.biopids.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Johnys
 */
@Entity
@Table(name="telefone")
public class Telefone extends EntityPersist{
	
	private static final long serialVersionUID = 1L;
	private String ddd;
	@Column(nullable=false)
	private String numero;
	
	public String getDdd(){
		return this.ddd;
	}
	
	public String getNumero(){
		return this.numero;
	}
	
	public void setDdd(String ddd){
		this.ddd = ddd;
	}
	
	public void setNumero(String numero){
		this.numero = numero;
	}
}

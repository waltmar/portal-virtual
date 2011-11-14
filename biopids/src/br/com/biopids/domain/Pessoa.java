/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.biopids.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Johnys
 */
@Entity
@Table(name="pessoa")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa extends EntityPersist{
    
	private static final long serialVersionUID = 1L;
	private String nome;
	@OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "endereco_codigo", insertable = true, updatable = true)
    private Endereco endereco;
	private String email;
	@OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "telefone1_codigo", insertable = true, updatable = true)
	private Telefone telefone1;
	@OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "telefone2_codigo", insertable = true, updatable = true)
	private Telefone telefone2;
	@OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "telefone3_codigo", insertable = true, updatable = true)
	private Telefone telefone3;
    
    public Pessoa(){
    	endereco = new Endereco();
    }
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Telefone getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(Telefone telefone1) {
		this.telefone1 = telefone1;
	}
	public Telefone getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(Telefone telefone2) {
		this.telefone2 = telefone2;
	}
	public Telefone getTelefone3() {
		return telefone3;
	}
	public void setTelefone3(Telefone telefone3) {
		this.telefone3 = telefone3;
	}

}

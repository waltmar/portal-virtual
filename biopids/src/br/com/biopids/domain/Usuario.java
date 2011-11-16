/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biopids.domain;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author cdl
 */
@Entity
@Table(name="usuario")
public class Usuario extends EntityPersist{
    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne(optional=true, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_codigo", insertable = true, updatable = true)
    private Empresa empresa;
	@Column(nullable=false)
    private String cpf;
	@Column(nullable=false)
    private String nome;
    private String email;
    @Column(nullable=true)
    private String username;
    private String password;
    @OneToMany
    private List<Autorizacao> autorizacoes;
    
    public Usuario (){
    	autorizacoes = new ArrayList<Autorizacao>();
    }
    
    public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

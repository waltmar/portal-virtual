
package br.com.biopids.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author cdl
 */
@Entity
@Table(name="usuario_sistema")
public class UsuarioSistema extends EntityPersist{
    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
    private String username;
    private String password;
    private Boolean enable;
    @ManyToOne
    private Filiado filiado;

    @ManyToMany
    private List<Autorizacao> autorizacoes;
 
    public UsuarioSistema() {
    }
      

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
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


	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}



	public Filiado getFiliado() {
		return filiado;
	}



	public void setFiliado(Filiado filiado) {
		this.filiado = filiado;
	}
	
	
}

package br.com.biopids.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_sistema")
public class UsuarioSistema extends EntityPersist {

	private static final long serialVersionUID = 1L;
	private String name;
	private String username;
	private String password;
	private String email;
	private Boolean enable;
	@ManyToOne
	@JoinColumn(name = "filiado_codigo", insertable = true, updatable = true)
	private Filiado filiado;

	// cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_sistema_autorizacao", joinColumns = @JoinColumn(name = "usuarios_codigo"), inverseJoinColumns = @JoinColumn(name = "autorizacoes_codigo"))
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

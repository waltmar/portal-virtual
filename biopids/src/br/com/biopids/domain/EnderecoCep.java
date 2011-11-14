package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class EnderecoCep implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "bairro_codigo", insertable = true, updatable = true)
	private Bairro bairro;
	@Column(name="endereco_codigo")
	@Id
	private Integer codigo;
	@Column(name="endereco_logradouro")
	private String logradouro;
	@Column(name="endereco_complemento")
	private String complemento;
	@Column(name="endereco_cep")
	private String cep;
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}

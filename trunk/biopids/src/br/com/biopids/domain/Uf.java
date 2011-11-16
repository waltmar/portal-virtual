package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uf")
public class Uf implements Serializable{
	
	@Id
	@Column(name="uf_codigo")
	private Integer ufCodigo;
	@Column(name="uf_sigla")
	private String sigla;
	@Column(name="uf_descricao")
	private String descricao;
	
	public String getSigla() {
		return sigla;
	}
	public Integer getUfCodigo() {
		return ufCodigo;
	}
	public void setUfCodigo(Integer ufCodigo) {
		this.ufCodigo = ufCodigo;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}

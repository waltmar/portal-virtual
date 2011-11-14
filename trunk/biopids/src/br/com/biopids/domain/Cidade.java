package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "uf_codigo", insertable = true, updatable = true)
	private Uf uf;
	@Id
	@Column(name="cidade_codigo")
	private Integer codigo;
	@Column(name="cidade_descricao")
	private String descricao;
	@Column(name="cidade_cep")
	private String cidadeCep;
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCidadeCep() {
		return cidadeCep;
	}
	public void setCidadeCep(String cidadeCep) {
		this.cidadeCep = cidadeCep;
	}

}

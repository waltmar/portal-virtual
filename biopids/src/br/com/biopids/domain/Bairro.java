package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bairro")
public class Bairro implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "cidade_codigo", insertable = true, updatable = true)
	private Cidade cidade;
	@Column(name="bairro_codigo")
	@Id
	private Integer codigo;
	@Column(name="bairro_descricao")
	private String descricao;
	@Column(name="setor_codigo")
	private Integer setorCodigo;
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
	public Integer getSetorCodigo() {
		return setorCodigo;
	}
	public void setSetorCodigo(Integer setorCodigo) {
		this.setorCodigo = setorCodigo;
	}
	
}

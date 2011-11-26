package br.com.biopids.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;




@Entity
@Table(name="pessoa_juridica")
public class PessoaJuridica extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	@Column(nullable=false,unique=true)
	private String cnpj;
	@Column(nullable=false)
	private String razaoSocial;
	private String observacao;
	
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}

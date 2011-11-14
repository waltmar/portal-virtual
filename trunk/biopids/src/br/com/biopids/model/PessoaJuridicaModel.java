package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.FieldBean;

public class PessoaJuridicaModel implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String codigo;
	@FieldBean(internalClass=true)
	private DadosEmpresa dadosEmpresa;
	@FieldBean(internalClass=true)
	private EnderecoEmpresa enderecoEmpresa;
	
	
	public PessoaJuridicaModel(){
		this.dadosEmpresa= new DadosEmpresa();
		this.enderecoEmpresa = new EnderecoEmpresa();
		
	}


	public DadosEmpresa getDadosEmpresa() {
		return dadosEmpresa;
	}


	public void setDadosEmpresa(DadosEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	}


	public EnderecoEmpresa getEnderecoEmpresa() {
		return enderecoEmpresa;
	}


	public void setEnderecoEmpresa(EnderecoEmpresa enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}

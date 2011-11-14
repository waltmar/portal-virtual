package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.annotation.InnerClassDomain;

public class PessoaFisicaModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	@FieldBean(internalClass=true)
	private DadosPessoais dadosPessoais;
	@FieldBean(internalClass=true)
	private DadosProfissionais dadosProfissionais;
	@FieldBean(internalClass=true)	
	private DadosResidenciais dadosResidenciais;
	
	public PessoaFisicaModel(){
		this.dadosPessoais= new DadosPessoais();
		this.dadosProfissionais = new DadosProfissionais();
		this.dadosResidenciais = new DadosResidenciais();
	}
	

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosProfissionais getDadosProfissionais() {
		return dadosProfissionais;
	}

	public void setDadosProfissionais(DadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public DadosResidenciais getDadosResidenciais() {
		return dadosResidenciais;
	}

	public void setDadosResidenciais(DadosResidenciais dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}
	
}

package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.annotation.InnerClassDomain;

public class DadosPessoais implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldBean(internalClass=false, displayName="CPF")
	private String cpf;
	@FieldBean(displayName="RG")
    private String rg;
    private String nome;
    @FieldBean(displayName="Dt. Nascimento")
    private String dataNascimento;
    private String sexo;
    private String naturalidade;
    private String nacionalidade;
    private String cidadeNascimento;
    private String mae;
    private String pai;
    private String estadoCivil;
    private String conjuge;
    private String escolaridade;
    private String observacoes;
    @InnerClassDomain(local={"contato1","codigo"})
    private String codigoContato1;
    @InnerClassDomain(local={"contato1","nome"})
    private String contato1;
    @InnerClassDomain(local={"contato1","telefone","codigo"})
    private String codigoTelefoneContato1;
    @InnerClassDomain(local={"contato1","telefone","numero"})
    private String telefone1;
    @InnerClassDomain(local={"contato1","telefone","ddd"})
    private String ddd1;
    @InnerClassDomain(local={"contato2","codigo"})
    private String codigoContato2;
    @InnerClassDomain(local={"contato2","nome"})
    private String contato2;
    @InnerClassDomain(local={"contato2","telefone","numero"})
    private String codigoTelefoneContato2;
    @InnerClassDomain(local={"contato2","telefone","numero"})
    private String telefone2;
    @InnerClassDomain(local={"contato2","telefone","ddd"})
    private String ddd2;
    private String email;

	public String getDdd1() {
		return ddd1;
	}

	public void setDdd1(String ddd1) {
		this.ddd1 = ddd1;
	}

	public String getDdd2() {
		return ddd2;
	}

	public void setDdd2(String ddd2) {
		this.ddd2 = ddd2;
	}

	public DadosPessoais(){}
    
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getConjuge() {
		return conjuge;
	}
	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getContato1() {
		return contato1;
	}
	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	
	public String getContato2() {
		return contato2;
	}
	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoContato1() {
		return codigoContato1;
	}

	public void setCodigoContato1(String codigoContato1) {
		this.codigoContato1 = codigoContato1;
	}

	public String getCodigoTelefoneContato1() {
		return codigoTelefoneContato1;
	}

	public void setCodigoTelefoneContato1(String codigoTelefoneContato1) {
		this.codigoTelefoneContato1 = codigoTelefoneContato1;
	}

	public String getCodigoContato2() {
		return codigoContato2;
	}

	public void setCodigoContato2(String codigoContato2) {
		this.codigoContato2 = codigoContato2;
	}

	public String getCodigoTelefoneContato2() {
		return codigoTelefoneContato2;
	}

	public void setCodigoTelefoneContato2(String codigoTelefoneContato2) {
		this.codigoTelefoneContato2 = codigoTelefoneContato2;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	
}

package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.InnerClassDomain;
import br.com.biopids.annotation.Validator;
import br.com.biopids.validator.NullValidator;

public class EnderecoEmpresa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Validator(required=true,validatorClass=NullValidator.class)
	@InnerClassDomain(local={"endereco", "cep"})
	private String cep;
	@InnerClassDomain(local={"endereco", "endereco"})
	@Validator(required=true,validatorClass=NullValidator.class)
	private String endereco;
	@InnerClassDomain(local={"endereco", "complemento"})
	private String complemento;
	@InnerClassDomain(local={"endereco", "numero"})
	private String numero;
	@InnerClassDomain(local={"endereco", "bairro"})
	@Validator(required=true,validatorClass=NullValidator.class)
	private String bairro;
	@InnerClassDomain(local={"endereco", "cidade"})
	@Validator(required=true,validatorClass=NullValidator.class)
	private String cidade;
	@InnerClassDomain(local={"endereco", "estado"})
	@Validator(required=true,validatorClass=NullValidator.class)
	private String estado;
	@InnerClassDomain(local={"telefone1","ddd"})
	private String ddd1;
	@InnerClassDomain(local={"telefone1","numero"})
	private String telefone1;
	@InnerClassDomain(local={"telefone2","ddd"})
	private String ddd2;
	@InnerClassDomain(local={"telefone2","numero"})
	private String telefone2;
	@InnerClassDomain(local={"telefone3","ddd"})
	private String ddd3;
	@InnerClassDomain(local={"telefone3","numero"})
	private String telefone3;
	
	
	public EnderecoEmpresa(){}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
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

	public String getDdd3() {
		return ddd3;
	}

	public void setDdd3(String ddd3) {
		this.ddd3 = ddd3;
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getTelefone3() {
		return telefone3;
	}
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	
	
	
}

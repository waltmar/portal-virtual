package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.annotation.Validator;
import br.com.biopids.validator.CNPJValidator;

public class DadosEmpresa implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@FieldBean(displayName="CNPJ")
	@Validator(required=true,validatorClass=CNPJValidator.class)
	private String cnpj;
	@FieldBean(name="nome", displayName="Nome Fantasia")
	private String nomeFantasia;
	private String razaoSocial;
	@FieldBean(name="observacao")
	private String obs;
	private String email;
	
	public DadosEmpresa(){}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

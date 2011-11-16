/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.biopids.domain;


import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.biopids.annotation.NoAnotations;
import br.com.biopids.annotation.Validator;
import br.com.biopids.validator.CPFValidator;
import br.com.biopids.validator.NumberOnlyValidator;


@Entity
@Table(name="pessoa_fisica")
public class PessoaFisica extends Pessoa{
 
	private static final long serialVersionUID = 1L;
	@Validator(validatorClass={CPFValidator.class})
	private String cpf;
	@Validator(validatorClass={NumberOnlyValidator.class}, required = false)
    private String rg;
    private Date dataNascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private Estado naturalidade;
    private String nacionalidade; 
    private String cidadeNascimento;
    private String mae;
    private String pai; 
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;
    private String conjuge;
    private String observacoes;
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contato1_codigo", insertable = true, updatable = true)
    private Contato contato1;
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contato2_codigo", insertable = true, updatable = true)
    private Contato contato2;
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "enderecoprofissional_codigo", insertable = true, updatable = true)
    private Endereco enderecoProfissional;
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "telefoneprofissional_codigo", insertable = true, updatable = true)
    private Telefone telefoneProfissional;
    private String empresa;
    @Enumerated(EnumType.STRING)
    private TipoImovel tipoImovel;
    private Double valorAluguel;
    private Double valorPrestacao;
    private String outrasRendas;
    private Double valorRendas;
    private String cargo;
    private Integer anosServico;
    private Integer mesesServico;
    private Double salario;
    private Integer anosResidencia;
    private Integer mesesResidencia;
    
    
    
    public PessoaFisica(){
    }
    	
    
	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Integer getAnosServico() {
		return anosServico;
	}


	public void setAnosServico(Integer anosServico) {
		this.anosServico = anosServico;
	}


	public Integer getMesesServico() {
		return mesesServico;
	}


	public void setMesesServico(Integer mesesServico) {
		this.mesesServico = mesesServico;
	}

	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public Integer getAnosResidencia() {
		return anosResidencia;
	}


	public void setAnosResidencia(Integer anosResidencia) {
		this.anosResidencia = anosResidencia;
	}


	public Integer getMesesResidencia() {
		return mesesResidencia;
	}


	public void setMesesResidencia(Integer mesesResidencia) {
		this.mesesResidencia = mesesResidencia;
	}


	public Double getValorAluguel() {
		return valorAluguel;
	}



	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}



	public Double getValorPrestacao() {
		return valorPrestacao;
	}



	public void setValorPrestacao(Double valorPrestacao) {
		this.valorPrestacao = valorPrestacao;
	}



	public TipoImovel getTipoImovel() {
		return tipoImovel;
	}



	public void setTipoImovel(TipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}



	public Telefone getTelefoneProfissional() {
		return telefoneProfissional;
	}



	public void setTelefoneProfissional(Telefone telefoneProfissional) {
		this.telefoneProfissional = telefoneProfissional;
	}



	public Endereco getEnderecoProfissional() {
		return enderecoProfissional;
	}



	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	public void setEnderecoProfissional(Endereco enderecoProfissional) {
		this.enderecoProfissional = enderecoProfissional;
	}



	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	
	public Contato getContato1() {
		return contato1;
	}

	public void setContato1(Contato contato1) {
		this.contato1 = contato1;
	}

	public Contato getContato2() {
		return contato2;
	}

	public void setContato2(Contato contato2) {
		this.contato2 = contato2;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}


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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Estado getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(Estado naturalidade) {
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

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
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


	public String getOutrasRendas() {
		return outrasRendas;
	}


	public void setOutrasRendas(String outrasRendas) {
		this.outrasRendas = outrasRendas;
	}


	public Double getValorRendas() {
		return valorRendas;
	}


	public void setValorRendas(Double valorRendas) {
		this.valorRendas = valorRendas;
	}	
	
	
}

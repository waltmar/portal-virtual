package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.InnerClassDomain;

public class DadosProfissionais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empresa;
	@InnerClassDomain(local={"enderecoProfissional","codigo"})
	private String codigoEnderecoProfissional;
	@InnerClassDomain(local={"enderecoProfissional","cep"})
	private String cep;
	@InnerClassDomain(local={"enderecoProfissional","endereco"})
	private String endereco;
	@InnerClassDomain(local={"enderecoProfissional","complemento"})
	private String complemento;
	@InnerClassDomain(local={"enderecoProfissional","bairro"})
	private String bairro;
	@InnerClassDomain(local={"enderecoProfissional","cidade"})
	private String cidade;
	@InnerClassDomain(local={"enderecoProfissional","estado"})
	private String estado;
	@InnerClassDomain(local={"telefoneProfissional","codigo"})
	private String codigoTelefoneProfissinal;
	@InnerClassDomain(local={"telefoneProfissional","ddd"})
	private String ddd;
	@InnerClassDomain(local={"telefoneProfissional","numero"})
	private String numero;
	private String anosServico;
	private String mesesServico;
	private String salario;
	private String cargo;
	private String outrasRendas;
	private String valorRendas;

	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getAnosServico() {
		return anosServico;
	}
	public void setAnosServico(String anosServico) {
		this.anosServico = anosServico;
	}
	public String getMesesServico() {
		return mesesServico;
	}
	public void setMesesServico(String mesesServico) {
		this.mesesServico = mesesServico;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCodigoEnderecoProfissional() {
		return codigoEnderecoProfissional;
	}
	public void setCodigoEnderecoProfissional(String codigoEnderecoProfissional) {
		this.codigoEnderecoProfissional = codigoEnderecoProfissional;
	}
	public String getCodigoTelefoneProfissinal() {
		return codigoTelefoneProfissinal;
	}
	public void setCodigoTelefoneProfissinal(String codigoTelefoneProfissinal) {
		this.codigoTelefoneProfissinal = codigoTelefoneProfissinal;
	}
	public String getOutrasRendas() {
		return outrasRendas;
	}
	public void setOutrasRendas(String outrasRendas) {
		this.outrasRendas = outrasRendas;
	}
	public String getValorRendas() {
		return valorRendas;
	}
	public void setValorRendas(String valorRendas) {
		this.valorRendas = valorRendas;
	}
	

}

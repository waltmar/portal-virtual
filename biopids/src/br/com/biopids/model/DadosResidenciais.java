package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.InnerClassDomain;
import br.com.biopids.annotation.NoAnotations;

public class DadosResidenciais implements Serializable{/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@InnerClassDomain(local={"endereco","codigo"})
	private String codigoEndereco;
	@InnerClassDomain(local={"endereco","cep"})
	private String cep;
	@InnerClassDomain(local={"endereco","endereco"})
	private String endereco;
	@InnerClassDomain(local={"endereco","complemento"})
	private String complemento;
	@InnerClassDomain(local={"endereco","numero"})
	private String numero;
	@InnerClassDomain(local={"endereco","bairro"})
	private String bairro;
	@InnerClassDomain(local={"endereco","cidade"})
	private String cidade;
	@InnerClassDomain(local={"endereco","estado"})
	private String estado;
	@InnerClassDomain(local={"endereco","pontoReferencia"})
	private String pontoReferencia;
	@InnerClassDomain(local={"telefone1","codigo"})
	private String codigoTelefone1;
	@InnerClassDomain(local={"telefone1","numero"})
	private String telefone1;
	@InnerClassDomain(local={"telefone1","ddd"})
	private String ddd1;
	@InnerClassDomain(local={"telefone2","codigo"})
	private String codigoTelefone2;
	@InnerClassDomain(local={"telefone2","numero"})
	private String telefone2;
	@InnerClassDomain(local={"telefone2","ddd"})
	private String ddd2;
	@InnerClassDomain(local={"telefone3","codigo"})
	private String codigoTelefone3;
	@InnerClassDomain(local={"telefone3","numero"})
	private String telefone3;
	@InnerClassDomain(local={"telefone3","ddd"})
	private String ddd3;
	private String tipoImovel;
	private String valorAluguel;
	private String valorPrestacao;
	private String mesesResidencia;
	private String anosResidencia;
	
	public DadosResidenciais(){}
	
	
	public String getValorAluguel() {
		return valorAluguel;
	}


	public void setValorAluguel(String valorAluguel) {
		this.valorAluguel = valorAluguel;
	}


	public String getValorPrestacao() {
		return valorPrestacao;
	}


	public void setValorPrestacao(String valorPrestacao) {
		this.valorPrestacao = valorPrestacao;
	}


	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getDdd1() {
		return ddd1;
	}

	public String getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(String codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public String getCodigoTelefone1() {
		return codigoTelefone1;
	}

	public void setCodigoTelefone1(String codigoTelefone1) {
		this.codigoTelefone1 = codigoTelefone1;
	}

	public String getCodigoTelefone2() {
		return codigoTelefone2;
	}

	public void setCodigoTelefone2(String codigoTelefone2) {
		this.codigoTelefone2 = codigoTelefone2;
	}

	public String getCodigoTelefone3() {
		return codigoTelefone3;
	}

	public void setCodigoTelefone3(String codigoTelefone3) {
		this.codigoTelefone3 = codigoTelefone3;
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


	public String getPontoReferencia() {
		return pontoReferencia;
	}


	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}


	public String getMesesResidencia() {
		return mesesResidencia;
	}


	public void setMesesResidencia(String mesesResidencia) {
		this.mesesResidencia = mesesResidencia;
	}


	public String getAnosResidencia() {
		return anosResidencia;
	}


	public void setAnosResidencia(String anosResidencia) {
		this.anosResidencia = anosResidencia;
	}
	

}

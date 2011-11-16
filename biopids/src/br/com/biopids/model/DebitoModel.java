package br.com.biopids.model;

import java.io.Serializable;
import java.util.Date;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.annotation.InnerClassDomain;

public class DebitoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@InnerClassDomain(local={"pessoa","nome"})
	private String devedor;
	@InnerClassDomain(local={"pessoa","codigo"})
	private String codigoDevedor;
	private String cpf;
	private String cnpj;
	@InnerClassDomain(local={"filiado","codigo"})
	private String filiado;
	private String dataCompra;
	private String dataVencimento;
	private String valor;
	private String parcela;
	private String status;
	
	public DebitoModel() {}
	
	
	public String getCodigoDevedor() {
		return codigoDevedor;
	}


	public void setCodigoDevedor(String codigoDevedor) {
		this.codigoDevedor = codigoDevedor;
	}


	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getDevedor() {
		return devedor;
	}
	public void setDevedor(String devedor) {
		this.devedor = devedor;
	}
	
	public String getFiliado() {
		return filiado;
	}
	public void setFiliado(String filiado) {
		this.filiado = filiado;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

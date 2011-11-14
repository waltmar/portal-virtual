package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.biopids.annotation.NoAnotations;


@Entity
@Table(name="cheque")
public class Cheque extends Debito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Banco banco;
	@ManyToOne
	private Filiado filiado;
	@Column(nullable=false)
	private String agencia;
	@Column(nullable=false)
	private String alinea;
	
	public Cheque clone(){
		Cheque cheque = new Cheque();
		cheque.setAlinea(this.alinea);
		cheque.setAgencia(this.agencia);
		cheque.setBanco(this.banco);
		cheque.setFiliado(this.filiado);
		cheque.setCodigo(getCodigo());
		cheque.setDataCompra(getDataCompra());
		cheque.setDataPagamento(getDataPagamento());
		cheque.setDataVencimento(getDataVencimento());
		cheque.setFiliado(getFiliado());
		cheque.setJuro(getJuro());
		cheque.setMulta(getMulta());
		cheque.setNegociado(getNegociado());
		cheque.setParcela(getParcela());
		cheque.setPessoa(getPessoa());
		cheque.setStatus(getStatus());
		cheque.setValor(getValor());
		cheque.setValorPago(getValorPago());
		return cheque;
	}
	
	public Filiado getFiliado() {
		return filiado;
	}
	public void setFiliado(Filiado filiado) {
		this.filiado = filiado;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getAlinea() {
		return alinea;
	}
	public void setAlinea(String alinea) {
		this.alinea = alinea;
	}
	

}

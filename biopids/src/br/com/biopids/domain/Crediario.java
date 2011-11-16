package br.com.biopids.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="crediario")
public class Crediario extends Debito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable=false)
	private String numeroContrato;
	
	public Crediario clone(){
		Crediario crediario= new Crediario();
		crediario.setNumeroContrato(this.numeroContrato);
		crediario.setDataCompra(getDataCompra());
		crediario.setDataPagamento(getDataPagamento());
		crediario.setDataVencimento(getDataVencimento());
		crediario.setFiliado(getFiliado());
		crediario.setJuro(getJuro());
		crediario.setMulta(getMulta());
		crediario.setNegociado(getNegociado());
		crediario.setParcela(getParcela());
		crediario.setPessoa(getPessoa());
		crediario.setStatus(getStatus());
		crediario.setValor(getValor());
		crediario.setValorPago(getValorPago());
		return crediario;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

}

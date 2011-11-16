package br.com.biopids.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="debito")
@Inheritance(strategy=InheritanceType.JOINED)
public class Debito extends EntityPersist{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Pessoa pessoa;
	@ManyToOne
	private Filiado filiado;
	private Date dataCompra;
	private Date dataVencimento;
	private Double valor;
	private Double valorPago;
	private Date dataPagamento;
	private boolean negociado;
	private Double multa;
	private Double juro;
	
	
	private Integer parcela;
	
	public Debito clone(){
		return new Debito();
	}
	
	
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public boolean getNegociado() {
		return negociado;
	}
	public void setNegociado(boolean negociado) {
		this.negociado = negociado;
	}
	public Double getMulta() {
		return multa;
	}
	public void setMulta(Double multa) {
		this.multa = multa;
	}
	public Double getJuro() {
		return juro;
	}
	public void setJuro(Double juro) {
		this.juro = juro;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Filiado getFiliado() {
		return filiado;
	}
	public void setFiliado(Filiado filiado) {
		this.filiado = filiado;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVecimento) {
		this.dataVencimento = dataVecimento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getParcela() {
		return parcela;
	}
	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}


}

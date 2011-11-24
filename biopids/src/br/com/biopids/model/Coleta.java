package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Coleta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoCatalogo;
	private String codigoColeta;
	private Date dataColeta;
	private String estagioDesenvolvimento;
	private String fenologia;
	private String metodo;
	private String sexo;
	private String tipoMontagem;
	private int numeroIndividuos;
	private List<Coletor> coletores;
	private String obsColeta;
	
	public Coleta(){
		this.coletores = new ArrayList<Coletor>();
	}
	
	
	public String getCodigoCatalogo() {
		return codigoCatalogo;
	}
	public void setCodigoCatalogo(String codigoCatalogo) {
		this.codigoCatalogo = codigoCatalogo;
	}
	public String getCodigoColeta() {
		return codigoColeta;
	}
	public void setCodigoColeta(String codigoColeta) {
		this.codigoColeta = codigoColeta;
	}
	public Date getDataColeta() {
		return dataColeta;
	}
	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}
	public String getEstagioDesenvolvimento() {
		return estagioDesenvolvimento;
	}
	public void setEstagioDesenvolvimento(String estagioDesenvolvimento) {
		this.estagioDesenvolvimento = estagioDesenvolvimento;
	}
	public String getFenologia() {
		return fenologia;
	}
	public void setFenologia(String fenologia) {
		this.fenologia = fenologia;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipoMontagem() {
		return tipoMontagem;
	}
	public void setTipoMontagem(String tipoMontagem) {
		this.tipoMontagem = tipoMontagem;
	}
	public int getNumeroIndividuos() {
		return numeroIndividuos;
	}
	public void setNumeroIndividuos(int numeroIndividuos) {
		this.numeroIndividuos = numeroIndividuos;
	}
	public List<Coletor> getColetores() {
		return coletores;
	}
	public void setColetores(List<Coletor> coletores) {
		this.coletores = coletores;
	}
	public String getObsColeta() {
		return obsColeta;
	}
	public void setObsColeta(String obsColeta) {
		this.obsColeta = obsColeta;
	}
	

}

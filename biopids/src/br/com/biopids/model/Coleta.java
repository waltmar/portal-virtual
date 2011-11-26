package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.biopids.annotation.InnerClassDomain;

public class Coleta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@InnerClassDomain(local={"coleta","codigoCatalogo"})
	private String codigoCatalogo;
	@InnerClassDomain(local={"coleta","codigoColeta"})
	private String codigoColeta;
	@InnerClassDomain(local={"coleta","dataColeta"})
	private String dataColeta;
	@InnerClassDomain(local={"coleta","estagioDesenvolvimento","codigo"})
	private String estagioDesenvolvimento;
	@InnerClassDomain(local={"coleta","fenologia","codigo"})
	private String fenologia;
	@InnerClassDomain(local={"coleta","metodo","codigo"})
	private String metodo;
	@InnerClassDomain(local={"coleta","sexo","codigo"})
	private String sexo;
	@InnerClassDomain(local={"coleta","tipoMontagem","codigo" })
	private String tipoMontagem;
	@InnerClassDomain(local={"coleta","numeroIndividuos"})
	private String numeroIndividuos;
	private List<Coletor> coletores;
	@InnerClassDomain(local={"coleta","obsColeta"})
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
	
	
	public String getDataColeta() {
		return dataColeta;
	}


	public void setDataColeta(String dataColeta) {
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
	
	public String getNumeroIndividuos() {
		return numeroIndividuos;
	}


	public void setNumeroIndividuos(String numeroIndividuos) {
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

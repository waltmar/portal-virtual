package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.InnerClassDomain;


public class Geografia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@InnerClassDomain(local={"geografia","pais","codigo"})
	private String pais;
	@InnerClassDomain(local={"geografia","estado","codigo"})
	private String estado;
	@InnerClassDomain(local={"geografia","municipio","codigo"})
	private String municipio;
	@InnerClassDomain(local={"geografia", "localidade"})
	private String localidade;
	@InnerClassDomain(local={"geografia", "latitude"})
	private String latitude;
	@InnerClassDomain(local={"geografia", "altitude"})
	private String altitude;
	@InnerClassDomain(local={"geografia", "longitude"})
	private String longitude;
	@InnerClassDomain(local={"geografia", "profundidade"})
	private String profundidade;
	@InnerClassDomain(local={"geografia", "precisao"})
	private String precisao;
	@InnerClassDomain(local={"geografia","massaDagua","codigo"})
	private String massaDagua;
	@InnerClassDomain(local={"geografia","datum","codigo"})
	private String datum;
	@InnerClassDomain(local={"geografia", "obsGeografia"})
	private String obsGeografia;
	
	public Geografia(){}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(String profundidade) {
		this.profundidade = profundidade;
	}

	public String getPrecisao() {
		return precisao;
	}
	public void setPrecisao(String precisao) {
		this.precisao = precisao;
	}
	public String getMassaDagua() {
		return massaDagua;
	}
	public void setMassaDagua(String massaDagua) {
		this.massaDagua = massaDagua;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getObsGeografia() {
		return obsGeografia;
	}
	public void setObsGeografia(String obsGeografia) {
		this.obsGeografia = obsGeografia;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	

}

package br.com.biopids.model;

import java.io.Serializable;

public class Geography implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pais;
	private String estado;
	private String municipio;
	private String localidade;
	private String latitude;
	private String altidude;
	private String longitude;
	private String profundidade;
	private String precisao;
	private String massaDagua;
	private String datum;
	private String obsGeografia;
	
	public Geography(){}
	
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

	public String getAltidude() {
		return altidude;
	}

	public void setAltidude(String altidude) {
		this.altidude = altidude;
	}
	
	
	

}

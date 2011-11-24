package br.com.biopids.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="geografia")
public class Geografia extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "pais_codigo", insertable = true, updatable = true)
	private Pais pais;
	@OneToOne
	@JoinColumn(name = "estado_codigo", insertable = true, updatable = true)
	private Estado estado;
	@OneToOne
	@JoinColumn(name = "municipio_codigo", insertable = true, updatable = true)
	private Municipio municipio;
	private String localidade;
	private Long latitude;
	private Long altitude;
	private Long longitude;
	private Long profundidade;
	private String precisao;
	@OneToOne
	@JoinColumn(name = "massa_dagua_codigo", insertable = true, updatable = true)
	private MassaDagua massaDagua;
	@OneToOne
	@JoinColumn(name = "datum_codigo", insertable = true, updatable = true)
	private Datum datum;
	private String obsGeografia;
	
	public Geografia(){}
	
	
	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Municipio getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getLocalidade() {
		return localidade;
	}


	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}


	public String getPrecisao() {
		return precisao;
	}
	public void setPrecisao(String precisao) {
		this.precisao = precisao;
	}
	
	public MassaDagua getMassaDagua() {
		return massaDagua;
	}


	public void setMassaDagua(MassaDagua massaDagua) {
		this.massaDagua = massaDagua;
	}


	public Datum getDatum() {
		return datum;
	}


	public void setDatum(Datum datum) {
		this.datum = datum;
	}


	public String getObsGeografia() {
		return obsGeografia;
	}
	public void setObsGeografia(String obsGeografia) {
		this.obsGeografia = obsGeografia;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getAltitude() {
		return altitude;
	}


	public void setAltitude(Long altitude) {
		this.altitude = altitude;
	}


	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Long getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(Long profundidade) {
		this.profundidade = profundidade;
	}
	
}

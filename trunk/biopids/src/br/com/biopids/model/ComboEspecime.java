package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.biopids.domain.Datum;
import br.com.biopids.domain.Estado;
import br.com.biopids.domain.MassaDagua;
import br.com.biopids.domain.Municipio;
import br.com.biopids.domain.Pais;

public class ComboEspecime implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Pais> paises;
	private List<Estado> estados;
	private List<Municipio> municipios;
	private List<MassaDagua> massasDagua;
	private List<Datum> datuns;

	public ComboEspecime() {
		this.paises= new ArrayList<Pais>();
		this.estados= new ArrayList<Estado>();
		this.municipios= new ArrayList<Municipio>();
		this.massasDagua= new ArrayList<MassaDagua>();
		this.datuns= new ArrayList<Datum>();
		
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public List<MassaDagua> getMassasDagua() {
		return massasDagua;
	}

	public void setMassasDagua(List<MassaDagua> massasDagua) {
		this.massasDagua = massasDagua;
	}

	public List<Datum> getDatuns() {
		return datuns;
	}

	public void setDatuns(List<Datum> datuns) {
		this.datuns = datuns;
	}
	
}

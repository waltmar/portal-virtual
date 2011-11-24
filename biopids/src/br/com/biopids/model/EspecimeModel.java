package br.com.biopids.model;

import java.io.Serializable;

import br.com.biopids.annotation.FieldBean;

public class EspecimeModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	@FieldBean(internalClass=true)
	private Coleta coleta;
	@FieldBean(internalClass=true)
	private Geografia geografia;
	@FieldBean(internalClass=true)
	private Taxonomia taxonomia;
	@FieldBean(internalClass=true)
	private Media media;
	
	
	public EspecimeModel() {
		this.coleta = new Coleta();
		this.geografia = new Geografia();
		this.taxonomia = new Taxonomia();
		this.media = new Media();
		
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Coleta getColeta() {
		return coleta;
	}



	public void setColeta(Coleta coleta) {
		this.coleta = coleta;
	}



	public Geografia getGeografia() {
		return geografia;
	}



	public void setGeografia(Geografia geografia) {
		this.geografia = geografia;
	}



	public Taxonomia getTaxonomia() {
		return taxonomia;
	}



	public void setTaxonomia(Taxonomia taxonomia) {
		this.taxonomia = taxonomia;
	}



	public Media getMedia() {
		return media;
	}



	public void setMedia(Media media) {
		this.media = media;
	}
	
	

	
	
	
}

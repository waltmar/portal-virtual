package br.com.biopids.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="especime")
public class Especime extends EntityPersist{

	private static final long serialVersionUID = 1L;
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "geografia_codigo", insertable = true, updatable = true)
	private Geografia geografia;
    
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "coleta_codigo", insertable = true, updatable = true)
    private Coleta coleta;
    
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "taxonomia_codigo", insertable = true, updatable = true)
    private Taxonomia taxonomia;
    
    @OneToOne(optional=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "outros_codigo", insertable = true, updatable = true)
    private Outros outros;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
   	@JoinTable(name = "especime_has_imagem", joinColumns = @JoinColumn(name = "especime_codigo"), inverseJoinColumns = @JoinColumn(name = "imagem_codigo"))
	private List<Imagem> imagem;
	
    
    public Especime(){
    	imagem = new ArrayList<Imagem>();
    }
    
    
    public Geografia getGeografia() {
		return geografia;
	}
	public void setGeografia(Geografia geografia) {
		this.geografia = geografia;
	}


	public List<Imagem> getImagem() {
		return imagem;
	}


	public void setImagem(List<Imagem> imagem) {
		this.imagem = imagem;
	}


	public Coleta getColeta() {
		return coleta;
	}


	public void setColeta(Coleta coleta) {
		this.coleta = coleta;
	}


	public Taxonomia getTaxonomia() {
		return taxonomia;
	}


	public void setTaxonomia(Taxonomia taxonomia) {
		this.taxonomia = taxonomia;
	}


	public Outros getOutros() {
		return outros;
	}


	public void setOutros(Outros outros) {
		this.outros = outros;
	}

	
    

}

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

	
    

}

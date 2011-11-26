package br.com.biopids.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.biopids.domain.Coletor;

@Entity
@Table(name="coleta")
public class Coleta extends EntityPersist{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoCatalogo;
	private String codigoColeta;
	private Date dataColeta;
	@OneToOne
	@JoinColumn(name = "estagio_desenvolvimento_codigo", insertable = true, updatable = true)
	private EstagioDesenvolvimento estagioDesenvolvimento;
	@OneToOne
	@JoinColumn(name = "fenologia_codigo", insertable = true, updatable = true)
	private Fenologia fenologia;
	@OneToOne
	@JoinColumn(name = "metodo_codigo", insertable = true, updatable = true)
	private Metodo metodo;
	@OneToOne
	@JoinColumn(name = "sexo_codigo", insertable = true, updatable = true)
	private Sexo sexo;
	@OneToOne
	@JoinColumn(name = "tipo_montagem_codigo", insertable = true, updatable = true)
	private TipoMontagem tipoMontagem;
	private Integer numeroIndividuos;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "coleta_has_coletor", joinColumns = @JoinColumn(name = "coleta_codigo"), inverseJoinColumns = @JoinColumn(name = "coletores_codigo"))
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
	
	
	public EstagioDesenvolvimento getEstagioDesenvolvimento() {
		return estagioDesenvolvimento;
	}
	public void setEstagioDesenvolvimento(
			EstagioDesenvolvimento estagioDesenvolvimento) {
		this.estagioDesenvolvimento = estagioDesenvolvimento;
	}
	public Fenologia getFenologia() {
		return fenologia;
	}
	public void setFenologia(Fenologia fenologia) {
		this.fenologia = fenologia;
	}
	public Metodo getMetodo() {
		return metodo;
	}
	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public TipoMontagem getTipoMontagem() {
		return tipoMontagem;
	}
	public void setTipoMontagem(TipoMontagem tipoMontagem) {
		this.tipoMontagem = tipoMontagem;
	}

	public Integer getNumeroIndividuos() {
		return numeroIndividuos;
	}


	public void setNumeroIndividuos(Integer numeroIndividuos) {
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

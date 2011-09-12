package br.com.scbio.ManagedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;



@ManagedBean(name="MenuBean")
@ViewScoped
public class MenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean panelEspecimes;
	private boolean panelBasicos;
	private boolean panelUsuarios;
	private boolean panelRelatorios;
	private boolean panelConfiguracoes;

	public MenuBean() {
		this.panelEspecimes = false;
		this.panelBasicos = true;
		this.panelUsuarios = false;
		this.panelRelatorios = false;
		this.panelConfiguracoes = false;
	}
	
	public void organizerPanel(boolean panel1, boolean panel2, boolean panel3,
			boolean panel4, boolean panel5) {
		this.panelEspecimes = panel1;
		this.panelBasicos = panel2;
		this.panelUsuarios = panel3;
		this.panelRelatorios = panel4;
		this.panelConfiguracoes = panel5;
	}

	public String especimes(ActionEvent event) {
		organizerPanel(true, false, false, false, false);
		return null;
	}

	public String basicos() {
		organizerPanel(false, true, false, false, false);
		return null;
	}
	
	public String usuarios() {
		organizerPanel(false, false, true, false, false);
		return null;
	}
	
	public String relatorios() {
		organizerPanel(false, false, false, true, false);
		return null;
	}
	public String configuracoes() {
		organizerPanel(false, false, false, false, true);
		return null;
	}
	


	public boolean isPanelBasicos() {
		return panelBasicos;
	}

	public void setPanelBasicos(boolean panelBasicos) {
		this.panelBasicos = panelBasicos;
	}

	public boolean isPanelEspecimes() {
		return panelEspecimes;
	}

	public void setPanelEspecies(boolean panelEspecimes) {
		this.panelEspecimes = panelEspecimes;
	}

	public boolean isPanelUsuarios() {
		return panelUsuarios;
	}

	public void setPanelUsuarios(boolean panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

	public boolean isPanelRelatorios() {
		return panelRelatorios;
	}

	public void setPanelRelatorios(boolean panelRelatorios) {
		this.panelRelatorios = panelRelatorios;
	}

	public boolean isPanelConfiguracoes() {
		return panelConfiguracoes;
	}

	public void setPanelConfiguracoes(boolean panelConfiguracoes) {
		this.panelConfiguracoes = panelConfiguracoes;
	}

}

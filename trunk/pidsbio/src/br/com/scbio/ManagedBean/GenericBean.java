package br.com.scbio.ManagedBean;

import java.io.Serializable;
import java.util.List;
import br.com.scbio.interfaces.IController;
import br.com.scbio.interfaces.IManagedBean;

import br.com.scbio.util.PropertiesLoader;

public abstract class GenericBean<T extends Serializable, oid extends Serializable>
		implements IManagedBean<T, oid>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean panelRegister;
	private boolean panelSearch;
	private boolean panelButtons;
	protected T objectDomain;
	//atributo usado para receber valores para as lists
	private String item;


	private PropertiesLoader properties;

	public GenericBean() {
		this.objectDomain = getDomain();
		loadVisiblePanels();
	}

	// --------------//Painel principal de busca e cadastro---------------------

	public void organizerPanel(boolean panel1, boolean panel2) {
		this.panelRegister = panel1;
		this.panelSearch = panel2;
	}

	public String searchView() {
		organizerPanel(false, true);
		return null;
	}

	public String registerView() {
		organizerPanel(true, false);
		return null;
	}

	// ------------------//paineis visiveis ao iniciar o managerbean-----------

	protected void loadVisiblePanels() {
		this.panelRegister = getDefaultPanelRegister();
		this.panelSearch = getDefaultPanelSearch();
	}

	private boolean getDefaultPanelSearch() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean getDefaultPanelRegister() {
		// TODO Auto-generated method stub
		return true;
	}

	// ------------------//----------------------------------------------------

	public abstract T getDomain();

	public abstract IController<T, oid> getIController();

	// ------------------//gets e sets-----------------------------------------

	public boolean isPanelRegister() {
		return panelRegister;
	}

	public void setPanelRegister(boolean panelRegister) {
		this.panelRegister = panelRegister;
	}

	public boolean isPanelSearch() {
		return panelSearch;
	}

	public void setPanelSearch(boolean panelSearch) {
		this.panelSearch = panelSearch;
	}

	public boolean isPanelButtons() {
		return panelButtons;
	}

	public void setPanelButtons(boolean panelButtons) {
		this.panelButtons = panelButtons;
	}


	public T getObjectDomain() {
		return objectDomain;
	}

	public void setObjectDomain(T objectDomain) {
		this.objectDomain = objectDomain;
	}

	public PropertiesLoader getProperties() {
		return properties;
	}

	public void setProperties(PropertiesLoader properties) {
		this.properties = properties;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	

}

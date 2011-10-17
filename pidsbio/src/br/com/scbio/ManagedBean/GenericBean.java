package br.com.scbio.ManagedBean;

import java.io.Serializable;
import java.util.List;
import br.com.scbio.interfaces.IController;
import br.com.scbio.interfaces.IManagedBean;
import br.com.scbio.interfaces.IPageNavigation;

import br.com.scbio.util.PropertiesLoader;

public abstract class GenericBean<T extends Serializable, oid extends Serializable>
		implements IManagedBean<T, oid>, IPageNavigation, Serializable {

	/**
	 * 
	 */
	private static final long ialVersionUID = 1L;
	private boolean panelRegister;
	private boolean panelSearch;

	private boolean panelButtons;
	private List<?> list;
	protected T objectDomain;
	private Object comboModel;

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

	public abstract Object getModel();

	public abstract T getDomain();

	public abstract Object loadCombos();

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

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public T getObjectDomain() {
		return objectDomain;
	}

	public void setObjectDomain(T objectDomain) {
		this.objectDomain = objectDomain;
	}

	public Object getComboModel() {
		return comboModel;
	}

	public void setComboModel(Object comboModel) {
		this.comboModel = comboModel;
	}

	public PropertiesLoader getProperties() {
		return properties;
	}

	public void setProperties(PropertiesLoader properties) {
		this.properties = properties;
	}

}

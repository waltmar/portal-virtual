package br.com.biopids.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.biopids.domain.Basic;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.model.BasicModel;
import br.com.biopids.model.ComboBasic;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;


@ManagedBean(name="ManagerBasic")
@ViewScoped
public class ManagerBasic extends GenericBean<Basic, Long> {
	    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * 
	 */
	
	public ManagerBasic(){
		super();  
	}
	
	protected void before() throws ErrorException {
		BasicModel basic = (BasicModel) objectModel;
		String tipo =  FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("TIPO");
		basic.setTipo(tipo);
		super.before();
	}
	
	public String chooseSave(){
		BasicModel basic = (BasicModel) objectModel;
		setParamsDialog(false, true, true, "saveAction", "exitDialogFound",
				properties.getValor("desejaSalvarEsteRegistro"), basic.getTipo() + ": " + basic.getValor(),
				properties.getValor("salvar"), properties.getValor("cancelar"));
		return null;
	}

	
	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}

	@Override
	public IController<Basic, Long> getIController() {
		return (IController<Basic, Long>) AppContext.getApplicationContext().getBean("ControllerBasic");
	}
	

	@Override
	public Object getModel() {
		return new BasicModel();
	}
	

	@Override
	public Basic getDomain() {
		return new Basic();
	}
	
	
	public Object loadCombos() {

		return null;	
	}
	
	public Boolean getDefaultButton() {
		return false;
	}
	
	public String[] getCollunsTableSearch(){
		return new String[]{"basic.codigo","basic.valor","basic.pai","basic.tipo"};
	}

	public String[] getOrdersTableSearch() {
		return new String[]{"basic.valor", "basic.status"};
	}
	
}

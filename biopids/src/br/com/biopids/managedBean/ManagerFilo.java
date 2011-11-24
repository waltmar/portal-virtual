package br.com.biopids.managedBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biopids.domain.Debito;
import br.com.biopids.domain.Filo;
import br.com.biopids.domain.Reino;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerFilo;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.managedListable.ListableReino;
import br.com.biopids.model.BasicModel;
import br.com.biopids.model.ComboFilo;
import br.com.biopids.model.FiloModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

@ManagedBean(name = "ManagerFilo")
@ViewScoped
public class ManagerFilo extends GenericBean<Filo, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboFilo combos;

	public ManagerFilo() {
		search();
	}

	public void save() {
		try {
			mapping();
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executeSearch();

		boolean result = true;
		result = valid();

		if (result) {
			super.save();
			this.objectModel = getModel();
			search();
		}

		this.objectModel = getModel();
		search();
	}

	public void update() {
		boolean result = true;
		result = valid();

		if (result) {
			super.update();
			this.objectModel = getModel();
			search();
		}

		this.objectModel = getModel();
		search();
	}

	public void afterUpdate() {
		// TODO Auto-generated method stub
		setMessage(FacesMessage.SEVERITY_INFO, FactoreProperties.loadPtbr()
				.getValor("atualizadoSucesso"), "");
		objectModel = getModel();
	}

	public boolean valid() {
		boolean result = true;
		result = getIController().isNotNull(getObjectDomain());
		if (!result) {
			setWarnError("ValorNulo");
			return false;
		}
		result = getIController().isNew(getObjectDomain(),
				(List<Filo>) getList());
		if (!result) {
			setWarnError("RegistroJaCadastrado");
			return false;
		}
		result = getIController().isValid(getObjectDomain());
		if (!result) {
			setWarnError("MenosDeTresCaracteres");
			return false;
		}
		return true;

	}

	@Override
	public Filo getDomain() {
		// TODO Auto-generated method stub
		return new Filo();
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return new FiloModel();
	}

	@Override
	public IControllerFilo<Filo, Long> getIController() {
		return (IControllerFilo<Filo, Long>) AppContext
				.getApplicationContext().getBean("ControllerFilo");
	}

	public String deleteAction() {
		boolean result = false;
		try {
			result = getIController().isFather(getObjectDomain());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "";

		if (result) {
			setMessage(FacesMessage.SEVERITY_ERROR, FactoreProperties
					.loadPtbr().getValor("NaoFoiPossivelDeletar"), "");
		} else {
			super.deleteAction();
		}
		return "";
	}

	protected void afterSelectObject() {

		setParamsDialog(false, true, true, "deleteAction", "exitDialogFound",
				getValorPtbr("desejaExcluir"), "", getValorPtbr("sim"),
				getValorPtbr("nao"));

	}


	public Object loadCombos() {
		combos = new ComboFilo();
		List<Reino> list = (List<Reino>)getControllerList().getList(ListableReino.class);
		combos.setReinos(list);
		return combos;
	}
	
	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}

	public String[] getCollunsTableSearch() {
	return new String[] { "filo.codigo", "filo.valor", "filo.reino" };
	}

	// protected String afterLoadObjectTable() {
	// return "/formularios/basicrecords/taxonomy/teste.xhtml";
	// }

	public String[] getOrdersTableSearch() {
		return new String[] { "filo.valor", "filo.status" };
	}

	public ComboFilo getCombos() {
		return combos;
	}

	public void setCombos(ComboFilo combos) {
		this.combos = combos;
	}
	
	
}

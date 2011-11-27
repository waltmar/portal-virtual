package br.com.biopids.managedBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biopids.domain.Classe;
import br.com.biopids.domain.Reino;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerClasse;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.managedListable.ListableReino;
import br.com.biopids.model.BasicModel;
import br.com.biopids.model.ComboClasse;
import br.com.biopids.model.ClasseModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

@ManagedBean(name = "ManagerClasse")
@ViewScoped
public class ManagerClasse extends GenericBean<Classe, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboClasse combos;

	public ManagerClasse() {
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
				(List<Classe>) getList());
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
	public Classe getDomain() {
		// TODO Auto-generated method stub
		return new Classe();
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return new ClasseModel();
	}

	@Override
	public IControllerClasse<Classe, Long> getIController() {
		return (IControllerClasse<Classe, Long>) AppContext
				.getApplicationContext().getBean("ControllerClasse");
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
		combos = new ComboClasse();
		List<Reino> list = (List<Reino>)getControllerList().getList(ListableReino.class);
		combos.setReinos(list);
		return combos;
	}
	
	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}

	public String[] getCollunsTableSearch() {
	return new String[] { "classe.codigo", "classe.valor", "classe.reino" };
	}

	// protected String afterLoadObjectTable() {
	// return "/formularios/basicrecords/taxonomy/teste.xhtml";
	// }

	public String[] getOrdersTableSearch() {
		return new String[] { "classe.valor", "classe.status" };
	}

	public ComboClasse getCombos() {
		return combos;
	}

	public void setCombos(ComboClasse combos) {
		this.combos = combos;
	}
	
	
}

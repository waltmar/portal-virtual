package br.com.biopids.managedBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.biopids.domain.TipoMontagem;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerTipoMontagem;
import br.com.biopids.model.BasicModel;
import br.com.biopids.model.TipoMontagemModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

@ManagedBean(name = "ManagerTipoMontagem")
@ViewScoped
public class ManagerTipoMontagem extends GenericBean<TipoMontagem, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManagerTipoMontagem() {
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
				(List<TipoMontagem>) getList());
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
	public TipoMontagem getDomain() {
		// TODO Auto-generated method stub
		return new TipoMontagem();
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return new TipoMontagemModel();
	}

	@Override
	public IControllerTipoMontagem<TipoMontagem, Long> getIController() {
		return (IControllerTipoMontagem<TipoMontagem, Long>) AppContext
				.getApplicationContext().getBean("ControllerTipoMontagem");
	}

	public String deleteAction() {
		boolean result = false;
	
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

	@Override
	public Object loadCombos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCollunsTableSearch() {
		return new String[] { "tipomontagem.codigo", "tipomontagem.valor" };
	}

	// protected String afterLoadObjectTable() {
	// return "/formularios/basicrecords/taxonomy/teste.xhtml";
	// }

	public String[] getOrdersTableSearch() {
		return new String[] { "tipomontagem.valor", "tipomontagem.status" };
	}

}

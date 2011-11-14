package br.com.biopids.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.biopids.controller.ControllerDebito;
import br.com.biopids.controller.ControllerPessoaFisica;
import br.com.biopids.controller.ControllerPessoaJuridica;
import br.com.biopids.domain.Alinea;
import br.com.biopids.domain.Banco;
import br.com.biopids.domain.Crediario;
import br.com.biopids.domain.Debito;
import br.com.biopids.domain.Filiado;
import br.com.biopids.domain.Pessoa;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.PessoaJuridica;
import br.com.biopids.domain.Usuario;
import br.com.biopids.domain.UsuarioSistema;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerDebito;
import br.com.biopids.model.ComboDebito;
import br.com.biopids.model.CrediarioModel;
import br.com.biopids.model.DebitoModel;
import br.com.biopids.model.ParcelasModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

public abstract class BeanDebito<T extends Serializable, oid extends Serializable>
		extends GenericBean<T, oid> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean panelEscolha;
	private boolean panelCadastroTipo;
	protected boolean panelCpf;
	protected boolean panelCnpj;
	protected boolean disableDevedor;
	protected boolean panelParcela;
	private List<Debito> debitos;
	private String option;
	protected boolean readOnly;

	public BeanDebito() {
		super();
		this.panelEscolha = true;
		this.panelCadastroTipo = false;
		this.panelCpf = false;
		this.panelCnpj = false;
		this.disableDevedor = true;
		this.panelParcela = false;
		this.readOnly = true;
		checkInit();
		checkFiliado();
	}
	
	private void checkFiliado() {
		// TODO Auto-generated method stub
		
		if (getUsuario().getFiliado().getCodigo() == null){
			readOnly = false;
		} else {
			DebitoModel dm = (DebitoModel) objectModel;
			dm.setFiliado(getUsuario().getFiliado().getCodigo().toString());
		}
	}  

	public Boolean getDefaultButtonSave() {
		return false;
	}

	public String removeParcel(T entity) {
		this.objectDomain = entity;
		loadProperties();
		setParamsDialog(false, true, true, "removeDebito", "exitDialogFound",
				properties.getValor("desejaExcluirEsteDebito"), "",
				properties.getValor("excluir"), properties.getValor("cancelar"));
		return null;
	}

	public void removeDebito() {
		debitos.remove(objectDomain);
	}

	public String voltar() {
		this.panelEscolha = true;
		this.panelCadastroTipo = false;
		return null;
	}

	public String generateParcels() {
		try {
			mapping();
			Debito debito = (Debito) objectDomain;
			debitos = new ArrayList<Debito>();
			debitos = getControllerDebito().generateParcels(debito);
			//clearObjectModel();
			this.panelParcela = true;
			setRenderedButtonSave(true);
		} catch (ErrorException e) {
			treatException(e);

		}
		return null;
	}

	public void findDevedor(String n) throws ErrorException {
		this.renderedDialog = getDefaultRenderedDialog();
		if (!n.equalsIgnoreCase("")) {
			if (n.length() > 16) {
				PessoaJuridicaToDebito((getControllerDebito()).findCnpj(n));
			} else
				PessoaFisicaToDebito((getControllerDebito()).findCpf(n));
		}
	}

	public void PessoaJuridicaToDebito(PessoaJuridica pj) {

		boolean result = validateCnpj();
		if (!result) {
			setMessage(FacesMessage.SEVERITY_INFO,
					properties.getValor("cnpjInvalido"), "");
		} else
			resolveMessageDialog(pj);

	}

	public void PessoaFisicaToDebito(PessoaFisica pf) {

		boolean result = validateCpf();

		if (!result) {
			setMessage(FacesMessage.SEVERITY_INFO,
					properties.getValor("cpfInvalido"), "");
		} else
			resolveMessageDialog(pf);

	}

	public void resolveMessageDialog(Pessoa pessoa) {

		if (pessoa == null) {
			setMethodDialogDevedorNotFound();
		} else {
			setDevedorInView(pessoa);
		}
	}

	protected void setMethodDialogDevedorNotFound() {
		resetParamsDialog();
		setNameInView("");
		String header = FactoreProperties.loadPtbr().getValor(
				"desejaCadastrarEsteDevedor");
		String ok = FactoreProperties.loadPtbr().getValor("sim");
		String cancel = FactoreProperties.loadPtbr().getValor("nao");
		setParamsDialog(true, true, true, "addDevedor", "exitDialog", header,
				null, ok, cancel);
	}

	protected void setMethodDialogInvalid(String text) {
		resetParamsDialog();
		setDevedorInView("", "");
		String header = FactoreProperties.loadPtbr().getValor(text);
		String ok = FactoreProperties.loadPtbr().getValor("ok");
		setParamsDialog(false, true, false, "exitDialog", "", header, null, ok,
				"");
	}

	protected void setMethodDialogDevedorFound(String devedor) {
		resetParamsDialog();
		String text = "Devedor: " + devedor;
		String header = FactoreProperties.loadPtbr().getValor(
				"devedorEncontrado");
		String ok = FactoreProperties.loadPtbr().getValor("ok");
		setParamsDialog(false, true, false, "exitDialogFound", "", header,
				text, ok, "");
	}

	public void setParamsDialog(boolean renderedImage,
			boolean renderedButtonOk, boolean renderedButtonCancel,
			String actionDialogMethodOk, String actionDialogMethodCancel,
			String headerDialog, String textDialog,
			String buttonDialogMessageOk, String buttonDialogMessageCancel) {
		setParamsDialogRendered(renderedImage, renderedButtonOk,
				renderedButtonCancel);
		setTextsInDialog(headerDialog, textDialog, buttonDialogMessageOk,
				buttonDialogMessageCancel);
		setActionsInDialog(actionDialogMethodOk, actionDialogMethodCancel);
	}

	public void setDevedorInView(Pessoa pessoa) {

		DebitoModel debito = (DebitoModel) objectModel;
		debito.setDevedor(pessoa.getNome());
		debito.setCodigoDevedor(pessoa.getCodigo().toString());
		if (pessoa instanceof PessoaJuridica) {
			PessoaJuridica pj = (PessoaJuridica) pessoa;
			debito.setCnpj(pj.getCnpj());
		} else {
			PessoaFisica pf = (PessoaFisica) pessoa;
			debito.setCpf(pf.getCpf());
		}
	}

	public void setDevedorInView(String devedor, String valor) {

		DebitoModel debito = (DebitoModel) objectModel;
		debito.setDevedor(devedor);
		debito.setCnpj(valor);
		debito.setCpf(valor);

	}

	private void setActionsInDialog(String actionDialogMethodOk,
			String actionDialogMethodCancel) {
		this.actionDialogMethodOk = actionDialogMethodOk;
		this.actionDialogMethodCancel = actionDialogMethodCancel;

	}

	private void setTextsInDialog(String headerDialog, String textDialog,
			String buttonDialogMessageOk, String buttonDialogMessageCancel) {

		this.headerDialog = headerDialog;
		this.textDialog = textDialog;
		this.buttonDialogMessageOk = buttonDialogMessageOk;
		this.buttonDialogMessageCancel = buttonDialogMessageCancel;

	}

	public boolean validateCnpj() {
		DebitoModel debito = (DebitoModel) objectModel;
		boolean aux = executeValidate("CNPJValidator", debito.getCnpj());
		if (!aux) {
			debito.setCnpj("");
			debito.setDevedor("");
		}
		return aux;
	}

	public boolean validateCpf() {
		DebitoModel debito = (DebitoModel) objectModel;
		boolean aux = executeValidate("CPFValidator", debito.getCpf());
		if (!aux) {
			debito.setCpf("");
			debito.setDevedor("");
		}
		return aux;
	}

	protected Boolean getDefaultRenderedDialog() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setNameInView(String devedor) {
		DebitoModel debito = (DebitoModel) objectModel;
		debito.setDevedor(devedor);
	}

	protected void pageInit(String attribute) {
		Pessoa pessoa;
		pessoa = getControllerDebito().solvePessoa(Long.valueOf(attribute));
		if (pessoa != null) {
			if (pessoa instanceof PessoaFisica) {
				movePanelFisico();
				setFields((PessoaFisica) pessoa);
			} else {
				movePanelJuridico();
				setFields((PessoaJuridica) pessoa);

			}
		}
	}

	private void setFields(PessoaJuridica pessoa) {
		// TODO Auto-generated method stub
		DebitoModel debito = (DebitoModel) objectModel;
		debito.setCnpj(pessoa.getCnpj());
		debito.setDevedor(pessoa.getNome());
		debito.setCodigoDevedor(pessoa.getCodigo().toString());
	}

	private void setFields(PessoaFisica pessoa) {
		// TODO Auto-generated method stub
		DebitoModel debito = (DebitoModel) objectModel;
		debito.setCpf(pessoa.getCpf());
		debito.setDevedor(pessoa.getNome());
		debito.setCodigoDevedor(pessoa.getCodigo().toString());

	}

	public IControllerDebito<Debito, Long> getControllerDebito() {
		return (IControllerDebito<Debito, Long>) AppContext
				.getApplicationContext().getBean("ControllerDebito");
	}

	public String addDevedor() {
		solveReturn();
		if (panelCpf) {
			DebitoModel debito = (DebitoModel) objectModel;
			setAttributeSession("cpf", debito.getCpf());
			return "pessoaFisica";
		} else {
			DebitoModel debito = (DebitoModel) objectModel;
			setAttributeSession("cnpj", debito.getCnpj());
			return "pessoaJuridica";
		}

	}

	protected void preparePage() {
		if (panelCpf == false)
			movePanelFisico();
		else
			movePanelJuridico();
	}

	public Boolean getDefaultButtonNew() {
		return false;
	}

	public Boolean getDefaultButtonResearch() {
		return false;
	}

	public Boolean getDefaultButton() {
		return false;
	}

	public String movePanelFisico() {
		organizerPanel(false, true, true, false);
		visibleButtons();
		return null;

	}

	public String movePanelJuridico() {
		organizerPanel(false, true, false, true);
		visibleButtons();
		return null;
	}

	public void organizerPanel(boolean panelEscolha, boolean panelCadastroTipo,
			boolean panelCpf, boolean panelCnpj) {
		this.panelEscolha = panelEscolha;
		this.panelCadastroTipo = panelCadastroTipo;
		this.panelCpf = panelCpf;
		this.panelCnpj = panelCnpj;
	}

	public String saveAction() {
		if (debitos == null || debitos.size() == 0) {
			setMessage(FacesMessage.SEVERITY_INFO,
					properties.getValor("gerar_debitos_antes_salvar"), "");
			setParamsDialog(false, true, false, "exitDialogFound", "",
					properties.getValor("gerar_debitos_antes_salvar"), "",
					properties.getValor("ok"),"");
		} else {
			try {
				panelDialog = true;
				getControllerDebito().saveListDebito(debitos);
				afterSave();
			} catch (ErrorException e) {
				treatException(e);
				panelDialog = false;
			}
		}
		return null;
	}

	protected void afterSave() {
		super.afterSave();
		objectModel = getModel();
		debitos = new ArrayList<Debito>();
		panelParcela = false;
	}

	public boolean isPanelEscolha() {
		return panelEscolha;
	}

	public void setPanelEscolha(boolean panelEscolha) {
		this.panelEscolha = panelEscolha;
	}

	public boolean isPanelCadastroTipo() {
		return panelCadastroTipo;
	}

	public void setPanelCadastro(boolean panelCadastroTipo) {
		this.panelCadastroTipo = panelCadastroTipo;
	}

	public boolean isPanelCpf() {
		return panelCpf;
	}

	public void setPanelCpf(boolean panelCpf) {
		this.panelCpf = panelCpf;
	}

	public boolean isPanelCnpj() {
		return panelCnpj;
	}

	public void setPanelCnpj(boolean panelCnpj) {
		this.panelCnpj = panelCnpj;
	}

	public boolean isDisableDevedor() {
		return disableDevedor;
	}

	public void setDisableDevedor(boolean disableDevedor) {
		this.disableDevedor = disableDevedor;
	}

	public boolean isPanelParcela() {
		return panelParcela;
	}

	public void setPanelParcela(boolean panelParcela) {
		this.panelParcela = panelParcela;
	}

	public List<Debito> getDebitos() {
		return debitos;
	}

	public void setDebitos(List<Debito> debitos) {
		this.debitos = debitos;
	}

	public void setPanelCadastroTipo(boolean panelCadastroTipo) {
		this.panelCadastroTipo = panelCadastroTipo;
	}

	protected void loadProperties() {
		properties = FactoreProperties.loadPtbr();
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
	

}

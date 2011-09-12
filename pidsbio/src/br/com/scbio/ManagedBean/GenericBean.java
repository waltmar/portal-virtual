package br.com.scbio.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.scbio.exception.ErrorException;
import br.com.scbio.exception.TypeErrors;
import br.com.scbio.interfaces.IController;
import br.com.scbio.interfaces.IManagedBean;
import br.com.scbio.interfaces.IPageNavigation;

public abstract class GenericBean<T extends Serializable, oid extends Serializable>
		implements IManagedBean<T, oid>, IPageNavigation, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IController<T, oid> iControler;
	private boolean panelEspecimes;
	private boolean panelBasicos;
	private boolean panelUsuarios;
	private boolean panelRelatorios;
	private boolean panelConfiguracoes;

	public GenericBean() {
		this.panelEspecimes = true;
		this.panelBasicos = false;
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

	public void especies() {
		organizerPanel(true, false, false, false, false);
	}

	public void basicos() {
		organizerPanel(false, true, false, false, false);
	}
	
	public void usuarios() {
		organizerPanel(false, false, true, false, false);
	}
	
	public void relatorios() {
		organizerPanel(false, false, false, true, false);
	}
	public void configuracoes() {
		organizerPanel(false, false, false, false, true);
	}
	

	public boolean isPanelEspecimes() {
		return panelEspecimes;
	}

	public void setPanelEspecimes(boolean panelEspecimes) {
		this.panelEspecimes = panelEspecimes;
	}

	public boolean isPanelBasicos() {
		return panelBasicos;
	}

	public void setPanelBasicos(boolean panelBasicos) {
		this.panelBasicos = panelBasicos;
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

	public IController<T, oid> getiControler() {
		return iControler;
	}

	public void setiControler(IController<T, oid> iControler) {
		this.iControler = iControler;
	}

	public void save(T entity) {

		try {
			checkControllerInstance();
			iControler.save(entity);
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	public void delete(T entity) {

		try {
			checkControllerInstance();
			iControler.delete(entity);
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	public void update(T entity) {

		try {
			checkControllerInstance();
			iControler.update(entity);
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	public T getById(T entity, oid id) {

		try {
			checkControllerInstance();
			return iControler.getById(entity, id);

		} catch (ErrorException e) {
			treatException(e);
			return null;
		}
	}

	public List<T> getAll(T entity) {

		try {
			checkControllerInstance();
			return iControler.getAll(entity);

		} catch (ErrorException e) {
			treatException(e);
			return null;
		}
	}

	protected void treatException(ErrorException erro) {

		switch (erro.getErro()) {
		case SEVERITY_INFO:
			setMessage(FacesMessage.SEVERITY_INFO,
					TypeErrors.SEVERITY_INFO.toString(), erro.getMessage());
			break;
		case SEVERITY_WARN:
			setMessage(FacesMessage.SEVERITY_WARN,
					TypeErrors.SEVERITY_WARN.toString(), erro.getMessage());
			break;
		case SEVERITY_ERROR:
			setMessage(FacesMessage.SEVERITY_WARN,
					TypeErrors.SEVERITY_WARN.toString(), erro.getMessage());
			break;
		case SEVERITY_FATAL:
			setMessage(FacesMessage.SEVERITY_WARN,
					TypeErrors.SEVERITY_WARN.toString(), erro.getMessage());
			break;
		default:
			;
		}
	}

	protected void setMessage(Severity facesMessage, String tipoMensagem,
			String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(facesMessage, tipoMensagem, mensagem));

	}

	public abstract IController<T, oid> getIController();

	private void checkControllerInstance() {
		if (iControler == null)
			iControler = getIController();

	}

	public abstract void newAction(ActionEvent actionEvent);

	public abstract void saveAction(ActionEvent actionEvent);

	public abstract void updateAction(ActionEvent actionEvent);

	public abstract void cancelAction(ActionEvent actionEvent);

	public abstract void deleteAction(ActionEvent actionEvent);

	public abstract void researchAction(ActionEvent actionEvent);

	public void getByFinger(Serializable entity) throws ErrorException {
		// TODO Auto-generated method stub

	}
}

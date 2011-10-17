package br.com.scbio.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.dialog.Dialog;
import sun.misc.Cleaner;
import br.com.scbio.domain.EntityPersist;
import br.com.scbio.exception.ErrorException;
import br.com.scbio.exception.TypeErrors;
import br.com.scbio.interfaces.IController;
import br.com.scbio.interfaces.IManagedBean;
import br.com.scbio.interfaces.IPageNavigation;
import br.com.scbio.util.FactoreProperties;
import br.com.scbio.util.PropertiesLoader;
import br.com.scbio.validator.ServiceValidator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public abstract class GenericBean<T extends Serializable, oid extends Serializable>
		implements IManagedBean<T, oid>, IPageNavigation, Serializable {

	/**
	 * 
	 */
	private static final long ialVersionUID = 1L;
	private boolean panelCadastro;
	private boolean panelPesquisa;
	private boolean panelButtons;
	private List<?> list;
	protected T objectDomain;
	private Object comboModel;
	private PropertiesLoader properties;
	private boolean renderedButtonNew;
	private boolean renderedButtonSave;
	private boolean renderedButtonResearch;
	protected String actionDialogMethodOk;
	protected String actionDialogMethodCancel;
	protected String actionDialogMethodConfirm;
	protected String headerDialog;
	protected Boolean renderedDialog;
	protected Boolean imageDialog;
	protected Boolean buttonDialogOk;
	protected Boolean buttonDialogCancel;
	protected String textDialog;
	protected String buttonDialogMessageOk;
	protected String buttonDialogMessageCancel;
	private String move;

	public GenericBean() {
		this.objectDomain = getDomain();
		loadVisiblePanels();
		loadProperties();

	}

	public String genericAction(String act) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchMethodException {
		Class<? extends GenericBean> cls = this.getClass();
		Method method = cls.getMethod(act);
		return (String) method.invoke(this);
	}

	public String actionDialogOk() throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		return genericAction(actionDialogMethodOk);
	}

	public String actionDialogCancel() throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		genericAction(actionDialogMethodCancel);
		return null;
	}

	public String actionDialogConfirm() throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		genericAction(actionDialogMethodConfirm);
		return null;
	}


	protected void setAttributeSession(String attribute, String value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(attribute, value);

	}

	protected String getAttributeSession(String attribute) {
		return (String) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(attribute);
	}

	protected void loadVisiblePanels() {

		movePanel();
		this.panelButtons = getDefaultButton();
		this.renderedButtonNew = getDefaultButtonNew();
		this.renderedButtonResearch = getDefaultButtonResearch();
		this.renderedButtonSave = getDefaultButtonSave();
		this.renderedDialog = getDefaultRenderedDialog();
	}
	
	private void movePanel() {
		this.move = getParamMove();
		if ((move == null) || (move.equalsIgnoreCase("1")))
			organizerPanel(true, false);
		else
			organizerPanel(false, true);
	};
	
	private String getParamMove() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("move");
	}
	
	protected Boolean getDefaultRenderedDialog() {
		// TODO Auto-generated method stub
		return true;
	}

	public String visibleButtons() {
		panelButtons = true;
		return null;
	}

	public String invisibleButtons() {
		panelButtons = false;
		return null;
	}

	protected void before(){}

	public void save() {
		try {

			getIController().save(objectDomain);
			afterSave();
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	protected void afterSave() {
		// TODO Auto-generated method stub
		loadProperties();

		setMethodDialogSave();
		setMessage(FacesMessage.SEVERITY_INFO, FactoreProperties.loadPtbr()
				.getValor("SalvoSucesso"), "");

	}
	
	protected void setMethodDialogSave() {
		resetParamsDialog();
		String header = FactoreProperties.loadPtbr().getValor("desejaCadastrarOutroRegistro");
		String ok = FactoreProperties.loadPtbr().getValor("sim");
		String cancel = FactoreProperties.loadPtbr().getValor("nao");
		setParamsDialog(true, true, true,"returnToInit", "exitDialog", header, null, ok, cancel);
	}
	
	public void setParamsDialog(boolean renderedImage, boolean renderedButtonOk, boolean renderedButtonCancel, String actionDialogMethodOk, String actionDialogMethodCancel,String headerDialog, String textDialog, String buttonDialogMessageOk, String buttonDialogMessageCancel){
		setParamsDialogRendered(renderedImage, renderedButtonOk, renderedButtonCancel);
		setTextsInDialog(headerDialog, textDialog, buttonDialogMessageOk, buttonDialogMessageCancel);
		setActionsInDialog(actionDialogMethodOk, actionDialogMethodCancel);
	}
	
	private void setActionsInDialog(String actionDialogMethodOk,
			String actionDialogMethodCancel) {
		this.actionDialogMethodOk = actionDialogMethodOk;
		this.actionDialogMethodCancel = actionDialogMethodCancel;
		
	}
	
	private void setTextsInDialog(String headerDialog,
			String textDialog, String buttonDialogMessageOk, String buttonDialogMessageCancel) {
		
		this.headerDialog = headerDialog;
		this.textDialog = textDialog;
		this.buttonDialogMessageOk = buttonDialogMessageOk;
		this.buttonDialogMessageCancel= buttonDialogMessageCancel;
		
	}


	private void loadProperties() {
		properties = FactoreProperties.loadPtbr();
	}

	public void delete() {

		try {
			getIController().delete(this.objectDomain);
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	public void update() {

		try {
			getIController().update(objectDomain);
			afterUpdate();
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	private void afterUpdate() {
		// TODO Auto-generated method stub
		setMessage(FacesMessage.SEVERITY_INFO, FactoreProperties.loadPtbr()
				.getValor("cadastroAtualizadoSucesso"), "");

	}

	public T getById(oid id) {

		try {
			before();
			return getIController().getById(this.objectDomain, id);

		} catch (ErrorException e) {
			treatException(e);
			return null;
		}
	}

	public List<T> getAll() {

		try {
			before();
			return getIController().getAll(this.objectDomain);
		} catch (ErrorException e) {
			treatException(e);
			return null;
		}
	}


	public void search() throws ErrorException {
		EntityPersist entityPersist = (EntityPersist) objectDomain;
		executeSearch();
	}

	private void executeSearch() {
		IController<T, oid> icontorler = getIController();
		try {
			this.list = icontorler.getByFinder(objectDomain,
					getCollunsTableSearch());
		} catch (ErrorException e) {
			treatException(e);
		}

	}

	public String newPage() {
		return "novo";
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

	public void validate(String classValidator, Object valueValidator,
			String fieldDestination) {
		ServiceValidator validator = getValidator();
		boolean result = executeValidate(classValidator, valueValidator, fieldDestination);
		if (!result) {
			setMessage(FacesMessage.SEVERITY_ERROR, validator.getMessage(), "");
		}
	}

	public boolean executeValidate(String classValidator,
			Object valueValidator, String fieldDestination) {
		ServiceValidator validator = getValidator();
		boolean result = true;
		try {
			result = validator.validate(classValidator,
					valueValidator.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ServiceValidator getValidator(){
		return new ServiceValidator();
	}
	

	public void organizerPanel(boolean panel1, boolean panel2) {
		this.panelCadastro = panel1;
		this.panelPesquisa = panel2;

	}

	@PostConstruct
	public void load() {
		setComboModel(loadCombos());
	}

	public String saveAction() throws ErrorException {
		before();
		chooseOperation();

		return null;
	}

	protected void preparePage() {
	};

	public void chooseOperation() {
		EntityPersist entityPersist = (EntityPersist) objectDomain;
		if (entityPersist.getId_item() == null)
			save();
		else
			update();
	}

	public T getByFinger(T entity) throws ErrorException {
		return null;
	}

	public void setObjectDomain(T objectDomain) {
		this.objectDomain = objectDomain;
	}

	public Boolean getDefaultButton() {
		return false;
	}

	public Boolean getDefaultButtonSave() {
		return true;
	}

	public Boolean getDefaultButtonNew() {
		return true;
	}

	public Boolean getDefaultButtonResearch() {
		return true;
	}

	public boolean isPanelCadastro() {
		return panelCadastro;
	}

	public void setPanelCadastro(boolean panelCadastro) {
		this.panelCadastro = panelCadastro;
	}

	public boolean isPanelPesquisa() {
		return panelPesquisa;
	}

	public void setPanelPesquisa(boolean panelPesquisa) {
		this.panelPesquisa = panelPesquisa;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public PropertiesLoader getProperties() {
		return properties;
	}

	public void setProperties(PropertiesLoader properties) {
		this.properties = properties;
	}

	public T getObjectDomain() {
		return objectDomain;
	}

	public boolean isPanelButtons() {
		return panelButtons;
	}

	public void setPanelButtons(boolean panelButtons) {
		this.panelButtons = panelButtons;
	}

	public void setComboModel(Object comboModel) {
		this.comboModel = comboModel;
	}

	public Object getComboModel() {
		return comboModel;
	}

	public String researchAction() {
		loadList();
		organizerPanel(false, true);
		return null;
	}

	public String registerAction() {
		if (panelCadastro = false) {
			organizerPanel(true, false);
		}
		return null;
	}

	public void loadList() {
		setList(getAll());
	}


	public void newAction(ActionEvent event) {
		this.objectDomain = getDomain();
		clearView();
	}

	private void clearView() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot veiwRoot = viewHandler.createView(context, context
				.getViewRoot().getViewId());
		context.setViewRoot(veiwRoot);
		// context.renderResponse();
	}

	public void clearObjectModel() {
	}

	public void updateAction(ActionEvent event) {
	}

	public void cancelAction(ActionEvent event) {
	}

	public String deleteAction() {
		delete();
		afterDelete();
		return null;
	}

	public void inactivateAction() throws ErrorException {
		inactivate();
		update();
	}

	public void inactivate() throws ErrorException {
		EntityPersist entity = (EntityPersist) getObjectDomain();
		objectDomain = getIController().getById((T) entity,
				(oid) entity.getId_item());
	}

	protected void afterDelete() {
		// TODO Auto-generated method stub
		list.remove(this.objectDomain);

	}

	public String setSelectObject(T entity) {
		this.objectDomain = entity;
		setMethodonDelete();
		return null;
	}

	protected void setMethodonDelete() {
		beforeMethodDialog();
		actionDialogMethodOk = "inactivate";
		actionDialogMethodCancel = "exitDialog";
		headerDialog = FactoreProperties.loadPtbr().getValor("desejaInativar");
	}

	private void beforeMethodDialog() {
		setParamsDialogRendered(true, true, true);
		setMessagesDialog(getProperties("sim"), getProperties("nao"));
	}
	
	protected void setMessagesDialog(String ok, String cancel) {
		this.buttonDialogMessageOk = ok;
		this.buttonDialogMessageCancel = cancel;
	}
	
	protected void resetParamsDialog(){
		setParamsDialogRendered(false, false, false);
		actionDialogMethodOk = "";
		actionDialogMethodCancel = "";
		headerDialog = "";
		setMessagesDialog("", "");
		textDialog="";
	}

	
	protected void setParamsDialogRendered(boolean image, boolean buttonOk, boolean buttonCancel){
		this.imageDialog = image;
		this.buttonDialogOk = buttonOk;
		this.buttonDialogCancel = buttonCancel;
	}
	
	protected String getProperties(String key){
		return FactoreProperties.loadPtbr().getValor(key);
	}

	public boolean isRenderedButtonNew() {
		return renderedButtonNew;
	}

	public void setRenderedButtonNew(boolean renderedButtonNew) {
		this.renderedButtonNew = renderedButtonNew;
	}

	public boolean isRenderedButtonSave() {
		return renderedButtonSave;
	}

	public void setRenderedButtonSave(boolean renderedButtonSave) {
		this.renderedButtonSave = renderedButtonSave;
	}

	public boolean isRenderedButtonResearch() {
		return renderedButtonResearch;
	}

	public void setRenderedButtonResearch(boolean renderedButtonResearch) {
		this.renderedButtonResearch = renderedButtonResearch;
	}

	public String[] getCollunsTableSearch() {
		return null;
	}

	public String getActionDialogMethodCancel() {
		return actionDialogMethodCancel;
	}

	public void setActionDialogMethodCancel(String actionDialogMethodCancel) {
		this.actionDialogMethodCancel = actionDialogMethodCancel;
	}

	public String getActionDialogMethodOk() {
		return actionDialogMethodOk;
	}

	public void setActionDialogMethodOk(String actionDialogMethodOk) {
		this.actionDialogMethodOk = actionDialogMethodOk;
	}

	public String getActionDialogMethodConfirm() {
		return actionDialogMethodConfirm;
	}

	public void setActionDialogMethodConfirm(String actionDialogMethodConfirm) {
		this.actionDialogMethodConfirm = actionDialogMethodConfirm;
	}

	public String getButtonDialogMessageOk() {
		return buttonDialogMessageOk;
	}

	public void setButtonDialogMessageOk(String buttonDialogMessageOk) {
		this.buttonDialogMessageOk = buttonDialogMessageOk;
	}

	public String getButtonDialogMessageCancel() {
		return buttonDialogMessageCancel;
	}

	public void setButtonDialogMessageCancel(String buttonDialogMessageCancel) {
		this.buttonDialogMessageCancel = buttonDialogMessageCancel;
	}

	public String returnToInit() {
		return "";
	}

	public String exitDialog() {
		objectDomain = getObjectDomain();
		return null;
	}
	
	public String exitDialogFound(){
		return null;
	}

	public Boolean getRenderedDialog() {
		return renderedDialog;
	}

	public void setRenderedDialog(Boolean renderedDialog) {
		this.renderedDialog = renderedDialog;
	}

	public String getHeaderDialog() {
		return headerDialog;
	}

	public void setHeaderDialog(String headerDialog) {
		this.headerDialog = headerDialog;
	}
	

	public Boolean getImageDialog() {
		return imageDialog;
	}

	public void setImageDialog(Boolean imageDialog) {
		this.imageDialog = imageDialog;
	}

	public Boolean getButtonDialogOk() {
		return buttonDialogOk;
	}

	public void setButtonDialogOk(Boolean buttonDialogOk) {
		this.buttonDialogOk = buttonDialogOk;
	}

	public Boolean getButtonDialogCancel() {
		return buttonDialogCancel;
	}

	public void setButtonDialogCancel(Boolean buttonDialogCancel) {
		this.buttonDialogCancel = buttonDialogCancel;
	}

	public String getTextDialog() {
		return textDialog;
	}

	public void setTextDialog(String textDialog) {
		this.textDialog = textDialog;
	}

	public abstract Object getModel();

	public abstract T getDomain();

	public abstract Object loadCombos();

	public abstract IController<T, oid> getIController();

}

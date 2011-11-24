package br.com.biopids.managedBean;

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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.biopids.converter.GenericConverterEntity;
import br.com.biopids.domain.EnderecoCep;
import br.com.biopids.domain.EntityPersist;
import br.com.biopids.domain.Status;
import br.com.biopids.domain.UsuarioSistema;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.exception.TypeErrors;
import br.com.biopids.exception.ValidateException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IManagedBean;
import br.com.biopids.interfaces.IPageNavigation;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;
import br.com.biopids.util.LoginBean;
import br.com.biopids.util.PropertiesLoader;
import br.com.biopids.validator.CleanField;
import br.com.biopids.validator.ServiceValidator;
import br.com.biopids.view.converterError.ConverterError;

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
	protected Object objectModel;
	private Object comboModel;
	protected PropertiesLoader properties;
	private String move;

	private boolean renderedButtonNew;
	private boolean renderedButtonSave;
	private boolean renderedButtonResearch;
	private UsuarioSistema usuario;
	private LoginBean login;
	protected String actionDialogMethodOk;
	protected String actionDialogMethodCancel;
	protected String actionDialogMethodConfirm;
	protected String headerDialog;
	protected Boolean renderedDialog;
	protected Boolean imageDialog;
	protected Boolean buttonDialogOk;
	protected Boolean buttonDialogCancel;
	protected String textDialog;

	protected static final String returnToRegister = "returnToRegister";
	protected static final String valueSession = "valueSession";
	protected String valueReturn;
	protected String url;
	protected String buttonDialogMessageOk;
	protected String buttonDialogMessageCancel;
	protected boolean panelDialog;
	protected String returnAction="";

	public GenericBean() {
		this.objectDomain = getDomain();
		this.objectModel = getModel();
		loadVisiblePanels();
		loadProperties();
		checkUserInSession();
		resetParamsDialog();
	}
	
	public String getValorPtbr(String valor){
		return FactoreProperties.loadPtbr().getValor(
		valor);
	}
	
	public void setWarnError(String text) {
		setMessage(FacesMessage.SEVERITY_WARN, FactoreProperties.loadPtbr()
				.getValor(text), "");
	}
	
	private void checkUserInSession() {
		this.usuario = (UsuarioSistema) getObjectInSession("usuarioSistema");
		if (usuario == null || usuario.getCodigo() == null){
			loadUser();
		} 
	}
	
	private void loadUser() {
		// TODO Auto-generated method stub
		usuario = new UsuarioSistema();
		login = new LoginBean();
		usuario = login.checkUsuarioController();	
		IController<UsuarioSistema, Long> controler = (IController<UsuarioSistema, Long>) AppContext.getApplicationContext().getBean("ControllerUsuarioSistema");		
		List<UsuarioSistema> list = null;
		try {
			list = (List<UsuarioSistema>) controler.getByFinder(usuario,"usuariosistema.codigo", "usuariosistema.username", "filiado.codigo");
		} catch (ErrorException e) {
		}
		setUserInSession(list.get(0));
		usuario = list.get(0);
	}

	private void setUserInSession(UsuarioSistema usuario) {
		// TODO Auto-generated method stub
		setObjectInSession("usuarioSistema", usuario);
	}

	private void checkUsuario() {
		// TODO Auto-generated method stub
		String user = getAttributeSession("usuario");
		if (user != null) {
			usuario = new UsuarioSistema();
			usuario.setUsername(user);
		}
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
		return returnAction;
	}

	public String actionDialogConfirm() throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		genericAction(actionDialogMethodConfirm);
		return null;
	}
	
	public EnderecoCep searchCEP(String cep){
		EnderecoCep enderecoCep = new EnderecoCep();
		enderecoCep.setCep(cep);
		List<EnderecoCep> list = null;
		IController<EnderecoCep, Integer> controlerCep = (IController<EnderecoCep, Integer>) AppContext.getApplicationContext().getBean("ControllerEnderecoCep");
		try {
			 list = controlerCep.getByFinder(enderecoCep, "enderecocep.logradouro", "enderecocep.complemento", "enderecocep.bairro.descricao", "enderecocep.bairro.cidade.descricao", "enderecocep.bairro.cidade.uf.sigla");
		} catch (ErrorException e) {
			treatException(e);
		}
		if(list != null && !list.isEmpty()){
			enderecoCep = list.get(0);
		}else{
			enderecoCep = null;
		}
		return enderecoCep;
	}
	
	public void actionSearchCEP(Object cep, String marcador){
		EnderecoCep enderecoCep = searchCEP(cep.toString().replaceAll("-", ""));
		if(enderecoCep != null){
			enderecoCep.setCep(cep.toString());
			setCEPInObjectModel(enderecoCep, marcador);
		}
	}

	

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	protected void checkInit() {
		// TODO Auto-generated method stub
		String attribute = getAttributeSession(valueSession);
		if (attribute != null) {
			pageInit(attribute);
			setAttributeSession(valueSession, null);
		}
	}

	protected void pageInit(String attribute) {
		// TODO Auto-generated method stub
	}

	protected String getUrLToReturn() {
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
	
	protected void setObjectInSession(String attribute, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(attribute, value);
	}

	protected Object getObjectInSession(String attribute) {
		return  FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(attribute);
	}

	protected void eraseAttributeSession(String attribute) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(attribute);
	}

	protected void solveReturn() {
		setAttributeSession(returnToRegister, getUrLToReturn());

	}

	protected void solveAttribute() {
		setAttributeSession(valueSession, valueReturn);
	}

	protected void loadVisiblePanels() {
		movePanel();
		this.panelButtons = getDefaultButton();
		this.renderedButtonNew = getDefaultButtonNew();
		this.renderedButtonResearch = getDefaultButtonResearch();
		this.renderedButtonSave = getDefaultButtonSave();
		this.renderedDialog = getDefaultRenderedDialog();
		this.panelDialog = getDefaultPanelDialog();
	}

	private boolean getDefaultPanelDialog() {
		// TODO Auto-generated method stub
		return true;
	}

	protected Boolean getDefaultRenderedDialog() {
		// TODO Auto-generated method stub
		return true;
	}

	private void movePanel() {
		this.move = getParamMove();
		if ((move == null) || (move.equalsIgnoreCase("1")))
			organizerPanel(true, false);
		else
			organizerPanel(false, true);
		objectModel = getModel();
	};

	private String getParamMove() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("move");
	}

	protected void loadObjectsControls() {
		// this.list = new ArrayList();
	}

	public String visibleButtons() {
		panelButtons = true;
		return null;
	}

	public String invisibleButtons() {
		panelButtons = false;
		return null;
	}

	protected void before() throws ErrorException {
		mapping();
		((EntityPersist) objectDomain).setStatus(Status.ATIVO);
	}

	public void save() {
		try {
			beforeSave();
			getIController().save(objectDomain);
			afterSave();
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	protected void beforeSave() {
		// TODO Auto-generated method stub
		
	}

	protected void afterSave() {
		// TODO Auto-generated method stub
		loadProperties();
		url = getAttributeSession(returnToRegister);

		if (url != null) {
			setAttributeSession(returnToRegister, null);
			EntityPersist entity = (EntityPersist) objectDomain;
			setAttributeSession(valueSession, entity.getCodigo().toString());
		}
		//setMethodDialogSave();
		setMessage(FacesMessage.SEVERITY_INFO, FactoreProperties.loadPtbr()
				.getValor("SalvoSucesso"), "");

	}

	protected void setMethodDialogSave() {
		resetParamsDialog();
		String header = FactoreProperties.loadPtbr().getValor(
				"desejaCadastrarOutroRegistro");
		String ok = FactoreProperties.loadPtbr().getValor("sim");
		String cancel = FactoreProperties.loadPtbr().getValor("nao");
		setParamsDialog(true, true, true, "returnToInit", "exitDialog", header,
				null, ok, cancel);
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

	protected void loadProperties() {
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

	public void updateInView() {

		try {
			getIController().update(objectDomain);
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	public void afterUpdate() {
		// TODO Auto-generated method stub
		setMethodDialigUpdate();
	}

	protected void setMethodDialigUpdate() {
		resetParamsDialog();
		String header = FactoreProperties.loadPtbr().getValor(
				"cadastroAtualizadoSucesso");
		String ok = FactoreProperties.loadPtbr().getValor("ok");
		String cancel = FactoreProperties.loadPtbr().getValor("nao");
		setParamsDialog(true, true, true, "returnToInit", "exitDialogUpdate",
				header, null, ok, cancel);
	}

	public String exitDialogUpdate() {
		return "principal";
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

	private ErrorException checkException(ErrorException error) {
		if (error instanceof ValidateException) {
			ConverterError converterError = new ConverterError(
					(GenericConverterEntity) AppContext.getApplicationContext()
							.getBean("GenericConverterEntity"),
					(ValidateException) error, this.objectModel);
			error = converterError.converter();
		}
		return error;

	}

	public void search() {
		try {
			mapping();
			EntityPersist entityPersist = (EntityPersist) objectDomain;
			executeSearch();
			afterSearch();
			this.objectDomain = getDomain();
		} catch (ErrorException e) {
			treatException(e);
		}
	}

	protected void afterSearch() {
		// TODO Auto-generated method stub
	}

	protected void executeSearch() {
		IController<T, oid> icontorler = getIController();
		try {
			this.list = icontorler.getByFinder(objectDomain, getOrdersTableSearch(),
					getCollunsTableSearch());
		} catch (ErrorException e) {
			treatException(e);
		}
	}
	
	

	public void newSearch() {
	}

	protected void treatException(ErrorException erro) {

		erro = checkException(erro);
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
		if (!valueValidator.toString().equalsIgnoreCase("")) {
			ServiceValidator validator = getValidator();
			boolean result = executeValidate(classValidator, valueValidator);
			if (!result) {
				setMessage(FacesMessage.SEVERITY_ERROR, validator.getMessage(),
						"");
				cleanField(fieldDestination);
			}
		}
	}

	public boolean executeValidate(String classValidator, Object valueValidator) {
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

	public ServiceValidator getValidator() {
		return (ServiceValidator) AppContext.getApplicationContext().getBean(
				"Validator");
	}

	private void cleanField(String fieldDestination) {
		CleanField cleanField = (CleanField) AppContext.getApplicationContext()
				.getBean("CleanField");
		try {
			cleanField.clean(this.objectModel, fieldDestination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void organizerPanel(boolean panel1, boolean panel2) {
		this.panelCadastro = panel1;
		this.panelPesquisa = panel2;

	}

	protected void mapping() throws ErrorException {
		this.objectDomain = getDomain();
		((GenericConverterEntity) AppContext.getApplicationContext().getBean(
				"GenericConverterEntity")).convertEntity(objectModel,
				objectDomain);
	}

	@PostConstruct
	public void load() {
		loadObjectsControls();
		setComboModel(loadCombos());
	}

	public String saveAction() {
		try {
			
			before();
			chooseOperation();
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			treatException(e);
		}

		return url;
	}

	protected void preparePage() {
	};

	public void chooseOperation() throws ErrorException {
		EntityPersist entityPersist = (EntityPersist) objectDomain;
		if (entityPersist.getCodigo() == null)
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

	public void setObjectModel(Object objectModel) {
		this.objectModel = objectModel;
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

	public static String getReturntoregister() {
		return returnToRegister;
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
		if (!panelCadastro) {
			organizerPanel(true, false);
		}
		return null;
	}

	public void loadList() {
		setList(getAll());
	}

	public Object getObjectModel() {
		return this.objectModel;
	}

	public void newAction(ActionEvent event) {
		this.objectModel = getModel();
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
		objectModel = getModel();
	}

	public void updateAction(ActionEvent event) {
	}

	public void cancelAction(ActionEvent event) {
	}

	public String deleteAction() {
		beforeDelete();
		delete();
		afterDelete();
		return null;
	}

	private void beforeDelete() {
		// TODO Auto-generated method stub
		
	}

	public String inactiveAction(T entity) throws ErrorException {
		setSelectObject(entity);
		setMethodonInativate();
		return null;
	}

	private void removeObjectInList(T entity) {
		list.remove(entity);
		// TODO Auto-generated method stub
	}

	public void inactivate() throws ErrorException {
		// removeObjectInList(objectDomain);
		EntityPersist entity = (EntityPersist) getObjectDomain();
		objectDomain = getIController().getById((T) entity,
				(oid) entity.getCodigo());
		entity = (EntityPersist) getObjectDomain();
		if (entity.getStatus() == Status.ATIVO) {
			entity.setStatus(Status.INATIVO);
		} else {
			entity.setStatus(Status.ATIVO);
		}
		updateInView();
		this.objectDomain = getDomain();
		search();
	}

	protected void afterDelete() {
		// TODO Auto-generated method stub
		list.remove(this.objectDomain);
		setMessage(FacesMessage.SEVERITY_INFO, FactoreProperties.loadPtbr()
				.getValor("registroExcluidoSucesso"), "");
	}

	public String loadObjectTable(T selectedObject) {
		this.objectDomain = (T) selectedObject;
		try {
			objectDomain = getIController().getById(objectDomain,
					(oid) ((EntityPersist) this.objectDomain).getCodigo());
			((GenericConverterEntity) AppContext.getApplicationContext()
					.getBean("GenericConverterEntity")).reconvertEntity(
					this.objectModel, this.objectDomain);
		} catch (ErrorException e) {
			treatException(e);
		}
		organizerPanel(true, false);
		
		return afterLoadObjectTable();
	}

	protected String afterLoadObjectTable() {
		// TODO Auto-generated method stub
		return "";
	}

	public String setSelectObject(T entity) {
		this.objectDomain = entity;
		afterSelectObject();
		return null;
	}
	

	protected void afterSelectObject() {
		// TODO Auto-generated method stub
		
	}

	protected void setMethodonInativate() {
		setParamsDialog(false, true, true, "inactivate", "exitDialogInView",
				properties.getValor("desejaAlterarStatus"), "",
				getProperties("sim"), getProperties("nao"));
		actionDialogMethodOk = "inactivate";
		actionDialogMethodCancel = "exitDialog";
		headerDialog = FactoreProperties.loadPtbr().getValor(
				"desejaAlterarStatus");
	}

	protected void setMessagesDialog(String ok, String cancel) {
		this.buttonDialogMessageOk = ok;
		this.buttonDialogMessageCancel = cancel;
	}

	protected void resetParamsDialog() {
		setParamsDialogRendered(false, false, false);
		actionDialogMethodOk = "";
		actionDialogMethodCancel = "";
		headerDialog = "";
		setMessagesDialog("", "");
		textDialog = "";
	}

	protected void setParamsDialogRendered(boolean image, boolean buttonOk,
			boolean buttonCancel) {
		this.imageDialog = image;
		this.buttonDialogOk = buttonOk;
		this.buttonDialogCancel = buttonCancel;
	}

	protected String getProperties(String key) {
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
	
	public String[] getOrdersTableSearch() {
		return null;
	}
	
	public void setCEPInObjectModel(EnderecoCep enderecoCep, String marcador) {}

	
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

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public String getValueReturn() {
		return valueReturn;
	}

	public void setValueReturn(String valueReturn) {
		this.valueReturn = valueReturn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		objectModel = getModel();
		return "/formularios/index.xhtml";
	}

	public String exitDialogFound() {
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

	public boolean isPanelDialog() {
		return panelDialog;
	}

	public void setPanelDialog(boolean panelDialog) {
		this.panelDialog = panelDialog;
	}
	
	
	public UsuarioSistema getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSistema usuario) {
		this.usuario = usuario;
	}

	public abstract Object getModel();

	public abstract T getDomain();

	public abstract Object loadCombos();

	public abstract IController<T, oid> getIController();

}

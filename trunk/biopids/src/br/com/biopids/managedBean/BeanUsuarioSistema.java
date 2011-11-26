package br.com.biopids.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.biopids.domain.Autorizacao;
import br.com.biopids.domain.Status;
import br.com.biopids.domain.UsuarioSistema;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.managedListable.ListableAutorizacao;
import br.com.biopids.managedListable.ListableFiliado;

import br.com.biopids.model.ComboUsuarioSistema;

import br.com.biopids.model.UserChangePassword;
import br.com.biopids.model.UsuarioSistemaModel;
import br.com.biopids.interfaces.IController;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;



@ViewScoped
@ManagedBean(name="BeanUsuarioSistema")
public class BeanUsuarioSistema extends GenericBean<UsuarioSistema, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String passwordNew;
	private String passwordNew2;
	private String messageValid="";
	private boolean roleFirst = false;
	private ComboUsuarioSistema combos;
	
	public BeanUsuarioSistema(){
		super();
		
	}
	
	protected void setMethodDialigUpdate() {
		resetParamsDialog();
		String header = FactoreProperties.loadPtbr().getValor(
				"cadastroAtualizado");
		String ok = FactoreProperties.loadPtbr().getValor("ok");

		setParamsDialog(true, true, false, "exitDialogUpdate", "",
				header, null, ok, "");
	}
	
	
	public void validUser(String classValidator, Object valueValidator,
			String fieldDestination) {
		super.validate(classValidator, valueValidator, fieldDestination);
		UsuarioSistemaModel usuario = (UsuarioSistemaModel) getObjectModel();
		String cpf = usuario.getUsername();
		if (!cpf.equalsIgnoreCase("")) {
			checkUser(cpf);
		} else {
			setObjectModel(getModel());
			panelDialog = false;
			setParamsDialog(false, true, false, "exitDialogFound", "",
					properties.getValor("cpfInvalido"),"",
					properties.getValor("ok"), "");
			
		}
	}

	private void checkUser(String cpf) {
		IController<UsuarioSistema, Long> controler = getIController();
		UsuarioSistema usuarioSistema = new UsuarioSistema();
		usuarioSistema.setUsername(cpf);
		List<UsuarioSistema> list = null;
		try {
			list = (List<UsuarioSistema>) controler.getByFinder(usuarioSistema,
					"usuariosistema.codigo", "usuariosistema.status");
		} catch (ErrorException e) {
			treatException(e);
		}
		
		checkUserList(list);
	}
	
	private void checkUserList(List<UsuarioSistema> list) {
		// TODO Auto-generated method stub
		if ((list != null) && (list.size() != 0)) {
			UsuarioSistemaModel usuario = (UsuarioSistemaModel) objectModel;
			usuario.setUsername("");
			panelDialog = true;
			setParamsDialog(false, true, false, "exitDialogFound", "",
					properties.getValor("usuarioJaCadastrado"), "",
					properties.getValor("ok"), "");
		} else panelDialog = false;
		
	}
	
	@Override
	public Object getModel() {
		return new UsuarioSistemaModel();
	}

	@Override
	public UsuarioSistema getDomain() {
		return new UsuarioSistema();
	}
	
	@Override
	public IController<UsuarioSistema, Long> getIController() {
		return (IController<UsuarioSistema, Long>) AppContext.getApplicationContext().getBean("ControllerUsuarioSistema");
		}
  
	@Override
	public Object loadCombos() {
		combos = new ComboUsuarioSistema();
		List<Autorizacao> list = (List<Autorizacao>)getControllerList().getList(ListableAutorizacao.class);
		combos.setAutorizacoes(list);
		return combos;
	}
	
	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}

	protected void before() throws ErrorException {

		objectDomain.setStatus(Status.ATIVO);
		super.before();
	}
	
	public Boolean getDefaultButtonNew(){
		return false;
	}
	public Boolean getDefaultButtonResearch(){
		return false;
	}
	public Boolean getDefaultButton() {
		return true;
	}
	
	public String[] getCollunsTableSearch(){
		return new String[]{"usuariosistema.codigo","usuariosistema.status", "usuariosistema.name","usuariosistema.username", "usuariosistema.email", "usuariosistema.username", "usuariosistema.password"};
	}
	
	public String[] getOrdersTableSearch() {
		return new String[]{"usuariosistema.name"};
	}
	
	protected void loadProperties() {
		properties = FactoreProperties.loadPtbr();
	}


	public String getPasswordNew() {
		return passwordNew;
	}


	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}


	public String getPasswordNew2() {
		return passwordNew2;
	}


	public void setPasswordNew2(String passwordNew2) {
		this.passwordNew2 = passwordNew2;
	}

	public String getMessageValid() {
		return messageValid;
	}

	public void setMessageValid(String messageValid) {
		this.messageValid = messageValid;
	}
	

}


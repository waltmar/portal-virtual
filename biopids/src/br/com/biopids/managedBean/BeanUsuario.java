package br.com.biopids.managedBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.Status;
import br.com.biopids.domain.Usuario;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.model.UsuarioModel;
import br.com.biopids.provider.AppContext;



@ViewScoped
@ManagedBean(name="BeanUsuario")
public class BeanUsuario extends GenericBean<Usuario, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BeanUsuario(){
		super();
		
		/*ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for (int i=0; i <= 50; i++ ){
			Usuario usuario= new Usuario();
			
			usuario.setCpf("0000"+ i);
			usuario.setEmail(i+"@gmail.com");
			
			usuario.setNome(i+"nome");
			usuarios.add(usuario);
			
		}
		setList(usuarios);*/		
	}
	
	@Override
	public Object getModel() {
		return new UsuarioModel();
	}

	@Override
	public Usuario getDomain() {
		return new Usuario();
	}
	
	
	@Override
	public IController<Usuario, Long> getIController() {
		return (IController<Usuario, Long>) AppContext.getApplicationContext().getBean("ControllerUsuario");
		}

	@Override
	public Object loadCombos() {
		return null;
		
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
		return new String[]{"usuario.codigo","usuario.status", "usuario.nome","usuario.empresa","usuario.cpf","usuario.email", "usuario.username", "usuario.password"};
	}
	
}


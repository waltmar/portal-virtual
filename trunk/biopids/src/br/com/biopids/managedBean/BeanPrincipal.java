package br.com.biopids.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.biopids.domain.Filiado;
import br.com.biopids.domain.UsuarioSistema;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.LoginBean;

@ViewScoped
@ManagedBean(name="BeanPrincipal")
public class BeanPrincipal extends GenericBean<UsuarioSistema, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BeanPrincipal(){
		super();
	
	}
	

	public IController<UsuarioSistema, Long> getIController() {
		return (IController<UsuarioSistema, Long>) AppContext.getApplicationContext().getBean("ControllerUsuarioSistema");
	}

	protected void setAttributeSession(String attribute, String value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(attribute, value);
	}
	
	protected void setObjectInSession(String attribute, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(attribute, value);
	}

	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioSistema getDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object loadCombos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}

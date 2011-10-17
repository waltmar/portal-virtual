package br.com.scbio.ManagedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.scbio.domain.EntityPersist;
import br.com.scbio.interfaces.IController;

@ManagedBean(name="ManagerSpecimens")
public class ManagerSpecimens extends GenericBean<EntityPersist, Serializable> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String newPage() {
		return "novo";
	}

	@Override
	public EntityPersist getDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object loadCombos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IController<EntityPersist, Serializable> getIController() {
		// TODO Auto-generated method stub
		return null;
	}

}
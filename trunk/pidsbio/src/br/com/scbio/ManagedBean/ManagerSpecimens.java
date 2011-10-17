package br.com.scbio.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.scbio.domain.EntityPersist;
import br.com.scbio.exception.ErrorException;
import br.com.scbio.interfaces.IController;

@ManagedBean(name="ManagerSpecimens")
@ViewScoped
public class ManagerSpecimens extends GenericBean<EntityPersist, Serializable> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ManagerSpecimens(){
		super();
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void save() throws ErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() throws ErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws ErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityPersist getById(Serializable id) throws ErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityPersist> getAll() throws ErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersist getByFinger(EntityPersist entity)
			throws ErrorException {
		// TODO Auto-generated method stub
		return null;
	}

}
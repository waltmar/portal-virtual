package br.com.scbio.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import br.com.scbio.domain.EntityPersist;
import br.com.scbio.exception.ErrorException;
import br.com.scbio.interfaces.IController;

@ManagedBean(name="ManagerBasic")
public class ManagerBasic extends GenericBean<EntityPersist, Serializable>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String valor;
	private String ancestor;
	protected List<?> list;
	protected List<String> combos;

	public ManagerBasic() {
		
		list = new ArrayList<String>();
	}
	
	
	public String getAncestor() {
		return ancestor;
	}

	public void setAncestor(String ancestor) {
		this.ancestor = ancestor;
	}

	public List<String> getCombos() {
		return combos;
	}

	public void setCombos(List<String> combos) {
		this.combos = combos;
	}
	
	

	public List<?> getList() {
		return list;
	}



	public void setList(List<?> list) {
		this.list = list;
	}



	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	


	@Override
	public IController<EntityPersist, Serializable> getIController() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public EntityPersist getDomain() {
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

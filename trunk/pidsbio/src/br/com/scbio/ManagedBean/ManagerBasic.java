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
	public void newAction(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAction(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelAction(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAction(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void researchAction(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public IController<EntityPersist, Serializable> getIController() {
		// TODO Auto-generated method stub
		return null;
	}

}

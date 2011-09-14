package br.com.scbio.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import br.com.scbio.domain.Basic;
import br.com.scbio.exception.ErrorException;
import br.com.scbio.interfaces.IController;

@ManagedBean(name="ManagerBasic")
public class ManagerBasic extends GenericBean<Basic, Serializable>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Basic basic;
	private String valor;
	private String ancestor;
	protected List<Basic> list;
	protected List combos;

	
	

	public ManagerBasic() {
		list = new ArrayList<Basic>();
		
	}
	

	public String getAncestor() {
		return ancestor;
	}

	public void setAncestor(String ancestor) {
		this.ancestor = ancestor;
	}

	public List getCombos() {
		return combos;
	}

	public void setCombos(List combos) {
		this.combos = combos;
	}
	
	public List<Basic> getList() {
		return list;
	}

	public void setList(List<Basic> list) {
		this.list = list;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Basic getBasic() {
		return basic;
	}
	public void setBasic(Basic basic) {
		this.basic = basic;
	}
	

	@Override
	public IController<Basic, Serializable> getIController() {
		// TODO Auto-generated method stub
		return null;
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

}

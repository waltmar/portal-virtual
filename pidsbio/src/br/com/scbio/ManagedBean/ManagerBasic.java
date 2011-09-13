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
	

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	

	public ManagerBasic() {
		super();
		setList(new ArrayList<String>());
		
	}
	
	public Basic getBasic() {
		return basic;
	}
	public void setBasic(Basic basic) {
		this.basic = basic;
	}
	@Override
	public void organizerPanel(boolean panel1, boolean panel2) {
		// TODO Auto-generated method stub
		
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

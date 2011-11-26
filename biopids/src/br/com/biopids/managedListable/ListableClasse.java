package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Classe;

import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableClasse extends AbstractGenericListable<Classe>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Classe, Long> ctrl;
	
	public ListableClasse(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Classe, Long> getIController() {
		return (IController<Classe, Long>) AppContext.getApplicationContext().getBean("ControllerClasse");
	}
	
	@Override
	protected List<Classe> getList() {
		List<Classe> list = null;
		try {
			list = ctrl.getAll(new Classe());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Classe, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Classe, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

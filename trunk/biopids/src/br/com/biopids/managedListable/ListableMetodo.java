package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Metodo;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableMetodo extends AbstractGenericListable<Metodo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Metodo, Long> ctrl;
	
	public ListableMetodo(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Metodo, Long> getIController() {
		return (IController<Metodo, Long>) AppContext.getApplicationContext().getBean("ControllerMetodo");
	}
	
	@Override
	protected List<Metodo> getList() {
		List<Metodo> list = null;
		try {
			list = ctrl.getAll(new Metodo());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Metodo, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Metodo, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

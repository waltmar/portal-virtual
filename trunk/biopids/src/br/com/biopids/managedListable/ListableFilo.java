package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Filo;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableFilo extends AbstractGenericListable<Filo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Filo, Long> ctrl;
	
	public ListableFilo(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Filo, Long> getIController() {
		return (IController<Filo, Long>) AppContext.getApplicationContext().getBean("ControllerFilo");
	}
	
	@Override
	protected List<Filo> getList() {
		List<Filo> list = null;
		try {
			list = ctrl.getAll(new Filo());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Filo, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Filo, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

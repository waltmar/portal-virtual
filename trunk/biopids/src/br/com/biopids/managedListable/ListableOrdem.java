package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Ordem;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableOrdem extends AbstractGenericListable<Ordem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Ordem, Long> ctrl;
	
	public ListableOrdem(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Ordem, Long> getIController() {
		return (IController<Ordem, Long>) AppContext.getApplicationContext().getBean("ControllerOrdem");
	}
	
	@Override
	protected List<Ordem> getList() {
		List<Ordem> list = null;
		try {
			list = ctrl.getAll(new Ordem());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Ordem, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Ordem, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

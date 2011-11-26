package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Familia;

import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableFamilia extends AbstractGenericListable<Familia>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Familia, Long> ctrl;
	
	public ListableFamilia(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Familia, Long> getIController() {
		return (IController<Familia, Long>) AppContext.getApplicationContext().getBean("ControllerFamilia");
	}
	
	@Override
	protected List<Familia> getList() {
		List<Familia> list = null;
		try {
			list = ctrl.getAll(new Familia());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Familia, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Familia, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.SubOrdem;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableSubOrdem extends AbstractGenericListable<SubOrdem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<SubOrdem, Long> ctrl;
	
	public ListableSubOrdem(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<SubOrdem, Long> getIController() {
		return (IController<SubOrdem, Long>) AppContext.getApplicationContext().getBean("ControllerSubOrdem");
	}
	
	@Override
	protected List<SubOrdem> getList() {
		List<SubOrdem> list = null;
		try {
			list = ctrl.getAll(new SubOrdem());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<SubOrdem, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<SubOrdem, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

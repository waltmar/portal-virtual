package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Cheque;
import br.com.biopids.domain.Estado;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableEstado extends AbstractGenericListable<Estado>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Estado, Long> ctrl;
	
	public ListableEstado(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Estado, Long> getIController() {
		return (IController<Estado, Long>) AppContext.getApplicationContext().getBean("ControllerEstado");
	}
	
	@Override
	protected List<Estado> getList() {
		List<Estado> list = null;
		try {
			list = ctrl.getAll(new Estado());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Estado, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Estado, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

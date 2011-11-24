package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Cheque;
import br.com.biopids.domain.Reino;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableReino extends AbstractGenericListable<Reino>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Reino, Long> ctrl;
	
	public ListableReino(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Reino, Long> getIController() {
		return (IController<Reino, Long>) AppContext.getApplicationContext().getBean("ControllerReino");
	}
	
	@Override
	protected List<Reino> getList() {
		List<Reino> list = null;
		try {
			list = ctrl.getAll(new Reino());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Reino, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Reino, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

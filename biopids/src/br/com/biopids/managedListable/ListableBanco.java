package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Banco;
import br.com.biopids.domain.Cheque;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableBanco extends AbstractGenericListable<Banco>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Banco, Long> ctrl;
	
	public ListableBanco(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Banco, Long> getIController() {
		return (IController<Banco, Long>) AppContext.getApplicationContext().getBean("ControllerBanco");
	}
	
	@Override
	protected List<Banco> getList() {
		List<Banco> list = null;
		try {
			list = ctrl.getAll(new Banco());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Banco, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Banco, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

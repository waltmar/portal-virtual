package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Alinea;
import br.com.biopids.domain.Cheque;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableAlinea extends AbstractGenericListable<Alinea>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Alinea, Long> ctrl;
	
	public ListableAlinea(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Alinea, Long> getIController() {
		return (IController<Alinea, Long>) AppContext.getApplicationContext().getBean("ControllerAlinea");
	}
	
	@Override
	protected List<Alinea> getList() {
		List<Alinea> list = null;
		try {
			list = ctrl.getAll(new Alinea());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Alinea, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Alinea, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

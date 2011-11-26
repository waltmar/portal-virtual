package br.com.biopids.managedListable;


import java.util.List;

import br.com.biopids.domain.Pais;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.provider.AppContext;

public class ListablePais extends AbstractGenericListable<Pais>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Pais, Long> ctrl;
	
	public ListablePais(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Pais, Long> getIController() {
		return (IController<Pais, Long>) AppContext.getApplicationContext().getBean("ControllerPais");
	}
	
	@Override
	protected List<Pais> getList() {
		List<Pais> list = null;
		try {
			list = ctrl.getAll(new Pais());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Pais, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Pais, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

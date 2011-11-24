package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Cheque;
import br.com.biopids.domain.Datum;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableDatum extends AbstractGenericListable<Datum>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Datum, Long> ctrl;
	
	public ListableDatum(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Datum, Long> getIController() {
		return (IController<Datum, Long>) AppContext.getApplicationContext().getBean("ControllerDatum");
	}
	
	@Override
	protected List<Datum> getList() {
		List<Datum> list = null;
		try {
			list = ctrl.getAll(new Datum());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Datum, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Datum, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

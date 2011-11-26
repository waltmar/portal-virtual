package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Fenologia;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableFenologia extends AbstractGenericListable<Fenologia>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Fenologia, Long> ctrl;
	
	public ListableFenologia(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Fenologia, Long> getIController() {
		return (IController<Fenologia, Long>) AppContext.getApplicationContext().getBean("ControllerFenologia");
	}
	
	@Override
	protected List<Fenologia> getList() {
		List<Fenologia> list = null;
		try {
			list = ctrl.getAll(new Fenologia());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Fenologia, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Fenologia, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

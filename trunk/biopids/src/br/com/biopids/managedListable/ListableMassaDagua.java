package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.MassaDagua;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableMassaDagua extends AbstractGenericListable<MassaDagua>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<MassaDagua, Long> ctrl;
	
	public ListableMassaDagua(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<MassaDagua, Long> getIController() {
		return (IController<MassaDagua, Long>) AppContext.getApplicationContext().getBean("ControllerMassaDagua");
	}
	
	@Override
	protected List<MassaDagua> getList() {
		List<MassaDagua> list = null;
		try {
			list = ctrl.getAll(new MassaDagua());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<MassaDagua, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<MassaDagua, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

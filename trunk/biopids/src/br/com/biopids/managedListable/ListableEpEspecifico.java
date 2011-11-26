package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.EpEspecifico;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableEpEspecifico extends AbstractGenericListable<EpEspecifico>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<EpEspecifico, Long> ctrl;
	
	public ListableEpEspecifico(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<EpEspecifico, Long> getIController() {
		return (IController<EpEspecifico, Long>) AppContext.getApplicationContext().getBean("ControllerEpEspecifico");
	}
	
	@Override
	protected List<EpEspecifico> getList() {
		List<EpEspecifico> list = null;
		try {
			list = ctrl.getAll(new EpEspecifico());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<EpEspecifico, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<EpEspecifico, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

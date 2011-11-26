package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.SubFamilia;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableSubFamilia extends AbstractGenericListable<SubFamilia>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<SubFamilia, Long> ctrl;
	
	public ListableSubFamilia(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<SubFamilia, Long> getIController() {
		return (IController<SubFamilia, Long>) AppContext.getApplicationContext().getBean("ControllerSubFamilia");
	}
	
	@Override
	protected List<SubFamilia> getList() {
		List<SubFamilia> list = null;
		try {
			list = ctrl.getAll(new SubFamilia());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<SubFamilia, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<SubFamilia, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

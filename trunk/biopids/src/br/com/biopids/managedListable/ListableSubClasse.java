package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.SubClasse;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableSubClasse extends AbstractGenericListable<SubClasse>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<SubClasse, Long> ctrl;
	
	public ListableSubClasse(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<SubClasse, Long> getIController() {
		return (IController<SubClasse, Long>) AppContext.getApplicationContext().getBean("ControllerSubClasse");
	}
	
	@Override
	protected List<SubClasse> getList() {
		List<SubClasse> list = null;
		try {
			list = ctrl.getAll(new SubClasse());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<SubClasse, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<SubClasse, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

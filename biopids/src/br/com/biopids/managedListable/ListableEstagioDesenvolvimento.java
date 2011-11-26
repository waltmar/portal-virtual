package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.EstagioDesenvolvimento;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableEstagioDesenvolvimento extends AbstractGenericListable<EstagioDesenvolvimento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<EstagioDesenvolvimento, Long> ctrl;
	
	public ListableEstagioDesenvolvimento(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<EstagioDesenvolvimento, Long> getIController() {
		return (IController<EstagioDesenvolvimento, Long>) AppContext.getApplicationContext().getBean("ControllerEstagioDesenvolvimento");
	}
	
	@Override
	protected List<EstagioDesenvolvimento> getList() {
		List<EstagioDesenvolvimento> list = null;
		try {
			list = ctrl.getAll(new EstagioDesenvolvimento());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<EstagioDesenvolvimento, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<EstagioDesenvolvimento, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

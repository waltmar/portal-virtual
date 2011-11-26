package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Filiado;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableFiliado extends AbstractGenericListable<Filiado>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Filiado, Long> ctrl;
	
	public ListableFiliado(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Filiado, Long> getIController() {
		return (IController<Filiado, Long>) AppContext.getApplicationContext().getBean("ControllerFiliado");
	}
	
	@Override
	protected List<Filiado> getList() {
		List<Filiado> list = null;
		try {
			list = ctrl.getAll(new Filiado());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Filiado, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Filiado, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

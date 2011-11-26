package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Autor;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.provider.AppContext;



public class ListableAutor extends AbstractGenericListable<Autor>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Autor, Long> ctrl;
	
	public ListableAutor(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Autor, Long> getIController() {
		return (IController<Autor, Long>) AppContext.getApplicationContext().getBean("ControllerAutor");
	}
	
	@Override
	protected List<Autor> getList() {
		List<Autor> list = null;
		try {
			list = ctrl.getAll(new Autor());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Autor, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Autor, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

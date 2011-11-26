package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Genero;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableGenero extends AbstractGenericListable<Genero>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Genero, Long> ctrl;
	
	public ListableGenero(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Genero, Long> getIController() {
		return (IController<Genero, Long>) AppContext.getApplicationContext().getBean("ControllerGenero");
	}
	
	@Override
	protected List<Genero> getList() {
		List<Genero> list = null;
		try {
			list = ctrl.getAll(new Genero());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Genero, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Genero, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

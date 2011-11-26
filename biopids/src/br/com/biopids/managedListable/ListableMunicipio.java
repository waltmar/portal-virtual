package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Municipio;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableMunicipio extends AbstractGenericListable<Municipio>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Municipio, Long> ctrl;
	
	public ListableMunicipio(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Municipio, Long> getIController() {
		return (IController<Municipio, Long>) AppContext.getApplicationContext().getBean("ControllerMunicipio");
	}
	
	@Override
	protected List<Municipio> getList() {
		List<Municipio> list = null;
		try {
			list = ctrl.getAll(new Municipio());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Municipio, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Municipio, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

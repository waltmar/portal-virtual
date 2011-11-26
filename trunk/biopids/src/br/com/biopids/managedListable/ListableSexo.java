package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Sexo;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.provider.AppContext;

public class ListableSexo extends AbstractGenericListable<Sexo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Sexo, Long> ctrl;
	
	public ListableSexo(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Sexo, Long> getIController() {
		return (IController<Sexo, Long>) AppContext.getApplicationContext().getBean("ControllerSexo");
	}
	
	@Override
	protected List<Sexo> getList() {
		List<Sexo> list = null;
		try {
			list = ctrl.getAll(new Sexo());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Sexo, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Sexo, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

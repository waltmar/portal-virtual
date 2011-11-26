package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.TipoMontagem;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;

import br.com.biopids.provider.AppContext;

public class ListableTipoMontagem extends AbstractGenericListable<TipoMontagem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<TipoMontagem, Long> ctrl;
	
	public ListableTipoMontagem(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<TipoMontagem, Long> getIController() {
		return (IController<TipoMontagem, Long>) AppContext.getApplicationContext().getBean("ControllerTipoMontagem");
	}
	
	@Override
	protected List<TipoMontagem> getList() {
		List<TipoMontagem> list = null;
		try {
			list = ctrl.getAll(new TipoMontagem());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<TipoMontagem, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<TipoMontagem, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

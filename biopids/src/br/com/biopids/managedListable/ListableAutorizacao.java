package br.com.biopids.managedListable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.biopids.domain.Autorizacao;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.AbstractGenericListable;
import br.com.biopids.provider.AppContext;



public class ListableAutorizacao extends AbstractGenericListable<Autorizacao>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IController<Autorizacao, Long> ctrl;
	
	public ListableAutorizacao(){
		super();
		this.ctrl = getIController();
	}
	
	public IController<Autorizacao, Long> getIController() {
		return (IController<Autorizacao, Long>) AppContext.getApplicationContext().getBean("ControllerAutorizacao");
	}
	
	@Override
	protected List<Autorizacao> getList() {
		List<Autorizacao> list = null;
		try {
			list = ctrl.getAll(new Autorizacao());
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public IController<Autorizacao, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Autorizacao, Long> ctrl) {
		this.ctrl = ctrl;
	}
	
	
}

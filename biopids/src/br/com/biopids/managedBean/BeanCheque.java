package br.com.biopids.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.biopids.domain.Alinea;
import br.com.biopids.domain.Banco;
import br.com.biopids.domain.Cheque;
import br.com.biopids.domain.Filiado;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.Status;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.managedListable.ListableAlinea;
import br.com.biopids.managedListable.ListableBanco;
import br.com.biopids.managedListable.ListableFiliado;
import br.com.biopids.model.ChequeModel;
import br.com.biopids.model.ComboCheque;
import br.com.biopids.model.ComboCrediario;
import br.com.biopids.model.ComboPessoaFisica;
import br.com.biopids.provider.AppContext;

@ManagedBean(name="BeanCheque")
@ViewScoped
public class BeanCheque extends BeanDebito<Cheque, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IController<Cheque, Long> ctrl;
	private ComboCheque combos;
	
	public BeanCheque(){
		super();
		
	}
	
	protected String getUrLToReturn(){
		return "cheque";
	}
	
 
	public ComboCheque getCombos() {
		return combos;
	}

	public void setCombos(ComboCheque combos) {
		this.combos = combos;
	}

	
	@Override
	public IController<Cheque, Long> getIController() {
		return (IController<Cheque, Long>) AppContext.getApplicationContext().getBean("ControllerCheque");
	}
	
	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}
		
	public IController<Cheque, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Cheque, Long> ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public Object loadCombos() {
		combos = new ComboCheque();
		List<Filiado> list = (List<Filiado>)getControllerList().getList(ListableFiliado.class);
		combos.setFiliados(list);
		List<Banco> listb = (List<Banco>)getControllerList().getList(ListableBanco.class);
		combos.setBancos(listb);
		List<Alinea> lista = (List<Alinea>)getControllerList().getList(ListableAlinea.class);
		combos.setAlineas(lista);
		
		return combos;
	}
	
	@Override
	public Object getModel() {
		return new ChequeModel();
	}

	@Override
	public Cheque getDomain() {
		return new Cheque();
	}
	
	
	

	
}

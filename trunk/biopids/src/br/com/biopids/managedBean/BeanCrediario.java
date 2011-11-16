package br.com.biopids.managedBean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;


import br.com.biopids.domain.Banco;
import br.com.biopids.domain.Cheque;
import br.com.biopids.domain.Crediario;
import br.com.biopids.domain.Escolaridade;
import br.com.biopids.domain.Filiado;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.PessoaJuridica;
import br.com.biopids.domain.Sexo;
import br.com.biopids.domain.Status;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.managedListable.ListableFiliado;
import br.com.biopids.model.ComboCheque;
import br.com.biopids.model.ComboCrediario;
import br.com.biopids.model.ComboPessoaFisica;
import br.com.biopids.model.CrediarioModel;
import br.com.biopids.provider.AppContext;

@ManagedBean(name="BeanCrediario")
@ViewScoped
public class BeanCrediario extends BeanDebito<Crediario, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IController<Crediario, Long> ctrl;
	private ComboCrediario combos;


	public BeanCrediario(){
		super();
		
	}
	
	
	protected String getUrLToReturn(){
		return "crediario";
	}
	
	protected void before() throws ErrorException {
		objectDomain.setStatus(Status.ATIVO);
		super.before();
	}
	

	public IController<Crediario, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Crediario, Long> ctrl) {
		this.ctrl = ctrl;
	}


	public IController<Crediario, Long> getIController() {
		return (IController<Crediario, Long>) AppContext.getApplicationContext().getBean("ControllerCrediario");
	}

	
	
	public ComboCrediario getCombos() {
		return combos;
	}

	public void setCombos(ComboCrediario combos) {
		this.combos = combos;
	}
	
	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}

	@Override
	public Object getModel() {
		return new CrediarioModel();
	}

	@Override
	public Crediario getDomain() {
		return new Crediario();
	}

	@Override
	public Object loadCombos() {
		combos = new ComboCrediario();
		List<Filiado> list = (List<Filiado>)getControllerList().getList(ListableFiliado.class);
		combos.setFiliados(list);
		return combos;
	}

	
}
package br.com.biopids.managedBean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.biopids.domain.Debito;
import br.com.biopids.domain.Escolaridade;
import br.com.biopids.domain.Estado;
import br.com.biopids.domain.EstadoCivil;
import br.com.biopids.domain.Nacionalidade;
import br.com.biopids.domain.Sexo;
import br.com.biopids.domain.Status;
import br.com.biopids.domain.TipoImovel;
import br.com.biopids.domain.Usuario;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.model.ComboDebitoPesquisa;
import br.com.biopids.model.ComboPessoaFisica;
import br.com.biopids.model.DebitoModel;
import br.com.biopids.provider.AppContext;

@ManagedBean(name="BeanDebitoPesquisa")
@ViewScoped
public class BeanDebitoPesquisa extends GenericBean<Debito, Long> {
	
	/** 
	 *  
	 */
	private ComboDebitoPesquisa combos;
	private static final long serialVersionUID = 1L;
	private IController<Debito, Long> ctrl;
	protected Debito debitoView;
	
	public BeanDebitoPesquisa(){
		super();
	}
	
	public String exitDialog() {
		objectModel = getModel();
		return null;
	}
	
	public String exitDialogUpdate() {
		return null;
	}
		
	protected void before() throws ErrorException {
		objectDomain.setStatus(Status.ATIVO);
		super.before();
	}
	 

	public IController<Debito, Long> getCtrl() {
		return ctrl;
	}

	public void setCtrl(IController<Debito, Long> ctrl) {
		this.ctrl = ctrl;
	}


	public Debito getDebitoView() {
		return debitoView;
	}

	public void setDebitoView(Debito debitoView) {
		this.debitoView = debitoView;
	}

	@Override
	public IController<Debito, Long> getIController() {
		// TODO Auto-generated method stub
		return (IController<Debito, Long>) AppContext.getApplicationContext().getBean("ControllerDebito");
	}
	
	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}
	
	@Override
	public Object getModel() {
		return new DebitoModel();
	}

	@Override
	public Debito getDomain() {
		return new Debito();
	}

	@Override
	public Object loadCombos() {
		combos = new ComboDebitoPesquisa();
		List<String> list = (List<String>)getControllerList().getList(Status.class); 
		combos.setStatus(list);
		return combos;
	}
	
	public String[] getCollunsTableSearch(){
		return new String[]{"debito.codigo","debito.status", "pessoa.nome","debito.dataCompra","debito.dataVencimento", "debito.valor", "debito.filiado.nome"};
	}
	
	public String[] getOrdersTableSearch() {
		return new String[]{"pessoa.nome", "debito.status"};
	}
	
	public String setSelectObjectInView(Object entity) {
		this.debitoView = (Debito) entity;
		return null;
	}
	
	protected void mapping() throws ErrorException {
		super.mapping();
		String f= getAttributeSession("filiado");
		Debito dm = (Debito) objectDomain;
		getObjectInSession("usuarioSistema");
		dm.setFiliado(getUsuario().getFiliado());
	}

	public ComboDebitoPesquisa getCombos() {
		return combos;
	}

	public void setCombos(ComboDebitoPesquisa combos) {
		this.combos = combos; 
	}  
	
	 
}
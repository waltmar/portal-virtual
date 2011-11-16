package br.com.biopids.managedBean;




import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.biopids.domain.EnderecoCep;
import br.com.biopids.domain.Escolaridade;
import br.com.biopids.domain.Estado;
import br.com.biopids.domain.EstadoCivil;
import br.com.biopids.domain.Nacionalidade;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.PessoaJuridica;
import br.com.biopids.domain.Sexo;
import br.com.biopids.domain.Status;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.model.ComboPessoaFisica;
import br.com.biopids.model.ComboPessoaJuridica;
import br.com.biopids.model.DebitoModel;
import br.com.biopids.model.PessoaFisicaModel;
import br.com.biopids.model.PessoaJuridicaModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

@ManagedBean(name="BeanPessoaJuridica")
@ViewScoped
public class BeanPessoaJuridica extends GenericBean<PessoaJuridica, Long> {
	    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboPessoaJuridica combos;
	private boolean readOnlyCNPJ;
	/** 
	 * 
	 */
	
	public BeanPessoaJuridica(){
		super();  
		checkAttributeCnpj();
		
	}
	
	private void checkAttributeCnpj() {
		String cnpj = getAttributeSession("cnpj");
		if (cnpj != null) {
			PessoaJuridicaModel pj = (PessoaJuridicaModel) objectModel;
			pj.getDadosEmpresa().setCnpj(cnpj);
			eraseAttributeSession("cnpj");
			readOnlyCNPJ = true;
		}else{
			readOnlyCNPJ = false;
		}
	}

	protected void afterSave() {
		super.afterSave();
		actionDialogMethodOk = "returnToInit";
		actionDialogMethodCancel = "exitDialog";
		headerDialog = FactoreProperties.loadPtbr().getValor("desejaCadastrarOutroRegistro");
	}
	
	public String returnToInit(){
		return "/formularios/pessoaJuridica/index.xhtml?move=1";
	}
	

	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}

	@Override
	public IController<PessoaJuridica, Long> getIController() {
		return (IController<PessoaJuridica, Long>) AppContext.getApplicationContext().getBean("ControllerPessoaJuridica");
	}
	
		
	public void next(ActionEvent actionEvent){}

	

	@Override
	public Object getModel() {
		return new PessoaJuridicaModel();
	}
	

	@Override
	public PessoaJuridica getDomain() {
		return new PessoaJuridica();
	}
	

	
	public Object loadCombos() {
		combos = new ComboPessoaJuridica();
		 		
		List<String> list = (List<String>)getControllerList().getList(Estado.class);
		combos.setEstados(list);
		
		// TODO Auto-generated method stub
		return combos;
		
	}
	public Boolean getDefaultButton() {
		return false;
	}
	
	public ComboPessoaJuridica getCombos() {
		return combos;
	}

	public void setCombos(ComboPessoaJuridica combos) {
		this.combos = combos;
	}
	
	public String[] getCollunsTableSearch(){
		return new String[]{"pessoajuridica.codigo","pessoajuridica.nome","pessoajuridica.cnpj","pessoajuridica.status","endereco.endereco","endereco.cidade", "endereco.cep", "pessoajuridica.email"};
	}
	
	public String[] getOrdersTableSearch() {
		return new String[]{"pessoajuridica.nome"};
	}
	
	public void validCadastroCNPJ(String classValidator, Object valueValidator, String fieldDestination){
		super.validate(classValidator, valueValidator, fieldDestination);
		PessoaJuridicaModel pfm = (PessoaJuridicaModel) getObjectModel();
		String cnpj = pfm.getDadosEmpresa().getCnpj();
		if(!cnpj.equalsIgnoreCase("")){
			loadPessoaJuridica(cnpj);
		}else{
			setObjectModel(getModel());
		}
		
	}

	private void loadPessoaJuridica(String cnpj) {
		IController<PessoaJuridica, Long> controler = getIController();
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj(cnpj);
		List<PessoaJuridica> list = null;
		try {
			list = (List<PessoaJuridica>) controler.getByFinder(pessoaJuridica, "pessoajuridica.codigo", "pessoajuridica.nome");
		} catch (ErrorException e) {
				treatException(e);
		}
		if((list != null)&&(list.size() != 0)){
			loadObjectTable(list.get(0));
		}
	}
	
	public void setCEPInObjectModel(EnderecoCep enderecoCep, String marcador) {
		PessoaJuridicaModel pfm = (PessoaJuridicaModel) objectModel;
		pfm.getEnderecoEmpresa().setCep(enderecoCep.getCep());
		pfm.getEnderecoEmpresa().setEndereco(enderecoCep.getLogradouro());
		pfm.getEnderecoEmpresa().setComplemento(enderecoCep.getComplemento());
		pfm.getEnderecoEmpresa().setCidade(enderecoCep.getBairro().getCidade().getDescricao());
		pfm.getEnderecoEmpresa().setBairro(enderecoCep.getBairro().getDescricao());
		pfm.getEnderecoEmpresa().setEstado(enderecoCep.getBairro().getCidade().getUf().getSigla());
		
	}

	public boolean isReadOnlyCNPJ() {
		return readOnlyCNPJ;
	}

	public void setReadOnlyCNPJ(boolean readOnlyCNPJ) {
		this.readOnlyCNPJ = readOnlyCNPJ;
	}
	
	

}

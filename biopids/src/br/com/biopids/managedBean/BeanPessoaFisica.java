package br.com.biopids.managedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.biopids.domain.Debito;
import br.com.biopids.domain.EnderecoCep;
import br.com.biopids.domain.Escolaridade;
import br.com.biopids.domain.Estado;
import br.com.biopids.domain.EstadoCivil;
import br.com.biopids.domain.Nacionalidade;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.Sexo;
import br.com.biopids.domain.Status;
import br.com.biopids.domain.TipoImovel;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.model.ComboPessoaFisica;
import br.com.biopids.model.DebitoModel;
import br.com.biopids.model.PessoaFisicaModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

@ManagedBean(name = "BeanPessoaFisica")
@ViewScoped
public class BeanPessoaFisica extends GenericBean<PessoaFisica, Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComboPessoaFisica combos;
	protected Debito debitoView;
	private boolean readOnlyCPF;
	private boolean panelResidenciaValor;
	private boolean panelValorAluguel;
	private boolean panelValorPrestacao;

	public BeanPessoaFisica() {
		super();
		checkAttributeCpf();
	}

	protected void loadVisiblePanels() {
		super.loadVisiblePanels();
		this.panelResidenciaValor = false;
		this.panelValorAluguel = false;
		this.panelValorPrestacao = false;
	}

	public void actionTipoImovel() {
		PessoaFisicaModel pf = (PessoaFisicaModel) objectModel;
		if (pf.getDadosResidenciais() != null && pf.getDadosResidenciais().getTipoImovel() != null ) {
		if (pf.getDadosResidenciais().getTipoImovel()
				.equalsIgnoreCase("Próprio financiado")) {
			caseFinanciado();
		} else if (pf.getDadosResidenciais().getTipoImovel()
				.equalsIgnoreCase("Alugado")) {
			caseAlugado();
		} else {
			this.panelResidenciaValor = false;
		} }
	}

	private void caseAlugado() {
		PessoaFisicaModel db= (PessoaFisicaModel) objectModel;
		db.getDadosResidenciais().setValorPrestacao("");
		this.panelResidenciaValor = true;
		this.panelValorAluguel = true;
		this.panelValorPrestacao = false;

	}

	private void caseFinanciado() {
		PessoaFisicaModel db= (PessoaFisicaModel) objectModel;
		db.getDadosResidenciais().setValorAluguel("");
		panelResidenciaValor = true;
		panelValorPrestacao = true;
		panelValorAluguel = false;

	}

	private void checkAttributeCpf() {
		String cpf = getAttributeSession("cpf");
		if (cpf != null) {
			eraseAttributeSession("cpf");
			PessoaFisicaModel pf = (PessoaFisicaModel) objectModel;
			pf.getDadosPessoais().setCpf(cpf);
			readOnlyCPF = true;
		} else {
			readOnlyCPF = false;
		}
	}

	protected void afterSave() {
		super.afterSave();
		actionDialogMethodOk = "returnToInit";
		actionDialogMethodCancel = "exitDialog";
		headerDialog = FactoreProperties.loadPtbr().getValor(
				"desejaCadastrarOutroRegistro");
	}

	public String returnToInit() {
		return "/formularios/pessoaFisica/index.xhtml?move=1";
	}

	public ControlerList getControllerList() {
		return (ControlerList) AppContext.getApplicationContext().getBean(
				"ControlerList");
	}

	@Override
	public IController<PessoaFisica, Long> getIController() {
		return (IController<PessoaFisica, Long>) AppContext
				.getApplicationContext().getBean("ControllerPessoaFisica");
	}

	public void saveContact() {

	}

	public void next(ActionEvent actionEvent) {
	}

	public Boolean getDefaultButton() {
		return false;
	}

	@Override
	public Object getModel() {
		return new PessoaFisicaModel();
	}

	@Override
	public PessoaFisica getDomain() {
		return new PessoaFisica();
	}

	@Override
	public Object loadCombos() {
		combos = new ComboPessoaFisica();
		List<String> list = (List<String>) getControllerList().getList(
				Sexo.class);
		combos.setSexos(list);
		list = (List<String>) getControllerList().getList(Escolaridade.class);
		combos.setEscolaridades(list);
		list = (List<String>) getControllerList().getList(TipoImovel.class);
		combos.setTiposImovel(list);
		list = (List<String>) getControllerList().getList(Estado.class);
		combos.setEstados(list);
		list = (List<String>) getControllerList().getList(EstadoCivil.class);
		combos.setEstadosCivis(list);
		list = (List<String>) getControllerList().getList(Nacionalidade.class);
		combos.setNacionalidades(list);
		// TODO Auto-generated method stub
		return combos;
	}

	protected void before() throws ErrorException {
		super.before();
	}

	public ComboPessoaFisica getCombos() {
		return combos;
	}

	public void setCombos(ComboPessoaFisica combos) {
		this.combos = combos;
	}

	public String[] getCollunsTableSearch() {
		return new String[] { "pessoafisica.codigo", "pessoafisica.status",
				"pessoafisica.nome", "pessoafisica.contato1.telefone.numero",
				"pessoafisica.cpf", "pessoafisica.endereco.endereco",
				"endereco.complemento", "endereco.numero", "endereco.bairro" };
	}

	public void setCEPInObjectModel(EnderecoCep enderecoCep, String marcador) {
		PessoaFisicaModel pfm = (PessoaFisicaModel) objectModel;
		if (marcador.equalsIgnoreCase("1")) {
			setCEPInDadosPessoais(pfm, enderecoCep);
		} else {
			setCEPInDadosProfissionais(pfm, enderecoCep);
		}
	}

	private void setCEPInDadosProfissionais(PessoaFisicaModel pfm,
			EnderecoCep enderecoCep) {
		pfm.getDadosProfissionais().setCep(enderecoCep.getCep());
		pfm.getDadosProfissionais().setEndereco(enderecoCep.getLogradouro());
		pfm.getDadosProfissionais()
				.setComplemento(enderecoCep.getComplemento());
		pfm.getDadosProfissionais().setCidade(
				enderecoCep.getBairro().getCidade().getDescricao());
		pfm.getDadosProfissionais().setBairro(
				enderecoCep.getBairro().getDescricao());
		pfm.getDadosProfissionais().setEstado(
				enderecoCep.getBairro().getCidade().getUf().getSigla());
	}

	private void setCEPInDadosPessoais(PessoaFisicaModel pfm,
			EnderecoCep enderecoCep) {
		pfm.getDadosResidenciais().setCep(enderecoCep.getCep());
		pfm.getDadosResidenciais().setEndereco(enderecoCep.getLogradouro());
		pfm.getDadosResidenciais().setComplemento(enderecoCep.getComplemento());
		pfm.getDadosResidenciais().setBairro(
				enderecoCep.getBairro().getDescricao());
		pfm.getDadosResidenciais().setCidade(
				enderecoCep.getBairro().getCidade().getDescricao());
		pfm.getDadosResidenciais().setEstado(
				enderecoCep.getBairro().getCidade().getUf().getSigla());

	}

	public String[] getOrdersTableSearch() {
		return new String[] { "pessoafisica.nome" };
	}

	public void validCadastroCPF(String classValidator, Object valueValidator,
			String fieldDestination) {
		super.validate(classValidator, valueValidator, fieldDestination);
		PessoaFisicaModel pfm = (PessoaFisicaModel) getObjectModel();
		String cpf = pfm.getDadosPessoais().getCpf();
		if (!cpf.equalsIgnoreCase("")) {
			loadPessoaFisica(cpf);
		} else {
			setObjectModel(getModel());
		}
	}

	private void loadPessoaFisica(String cpf) {
		IController<PessoaFisica, Long> controler = getIController();
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCpf(cpf);
		List<PessoaFisica> list = null;
		try {
			list = (List<PessoaFisica>) controler.getByFinder(pessoaFisica,
					"pessoafisica.codigo", "pessoafisica.nome");
		} catch (ErrorException e) {
			treatException(e);
		}
		if ((list != null) && (list.size() != 0)) {
			loadObjectTable(list.get(0));
		}
	}

	protected String afterLoadObjectTable() {
		actionTipoImovel();
		return null;
	}

	public boolean isReadOnlyCPF() {
		return readOnlyCPF;
	}

	public void setReadOnlyCPF(boolean readOnlyCPF) {
		this.readOnlyCPF = readOnlyCPF;
	}

	public boolean isPanelResidenciaValor() {
		return panelResidenciaValor;
	}

	public void setPanelResidenciaValor(boolean panelResidenciaValor) {
		this.panelResidenciaValor = panelResidenciaValor;
	}

	public boolean isPanelValorAluguel() {
		return panelValorAluguel;
	}

	public void setPanelValorAluguel(boolean panelValorAluguel) {
		this.panelValorAluguel = panelValorAluguel;
	}

	public boolean isPanelValorPrestacao() {
		return panelValorPrestacao;
	}

	public void setPanelValorPrestacao(boolean panelValorPrestacao) {
		this.panelValorPrestacao = panelValorPrestacao;
	}

}

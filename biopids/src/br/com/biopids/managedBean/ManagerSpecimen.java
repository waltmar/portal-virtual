package br.com.biopids.managedBean;




import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.biopids.domain.Specimen;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.model.Collector;
import br.com.biopids.model.ComboSpecimen;
import br.com.biopids.model.SpecimenModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;



@ManagedBean(name="ManagerSpecimen")
@ViewScoped
public class ManagerSpecimen extends GenericBean<Specimen, Long> {
	    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboSpecimen combos;
	private boolean readOnlyCNPJ;
	private Collector collector;
	/** 
	 * 
	 */
	
	public ManagerSpecimen(){
		super();  
		collector = new Collector();
		checkAttributeCnpj();
	}
	
	public String newCollector(){
		collector = new Collector();
		return null;
	}
	
	public String removeCollector(Collector object){
		SpecimenModel specimen = (SpecimenModel) objectModel;
		specimen.getCollect().getColetores().remove(object);
		return null;
	}
	

	public String addCollector() {
		if (collector.getNome() != null) {
			SpecimenModel specimen = (SpecimenModel) objectModel;
			specimen.getCollect().getColetores().add(collector);
			collector = new Collector();
		}
		return null;
	}
	
	private void checkAttributeCnpj() {
		/*
		String cnpj = getAttributeSession("cnpj");
		if (cnpj != null) {
			SpecimenModel pj = (SpecimenModel) objectModel;
			pj.getDadosEmpresa().setCnpj(cnpj);
			eraseAttributeSession("cnpj");
			readOnlyCNPJ = true;
		}else{
			readOnlyCNPJ = false;
		}
		*/
	}

	protected void afterSave() {
		super.afterSave();
		actionDialogMethodOk = "returnToInit";
		actionDialogMethodCancel = "exitDialog";
		headerDialog = FactoreProperties.loadPtbr().getValor("desejaCadastrarOutroRegistro");
	}
	
	public String returnToInit(){
		return "/formularios/Specimen/index.xhtml?move=1";
	}
	

	public ControlerList getControllerList(){
		return (ControlerList) AppContext.getApplicationContext().getBean("ControlerList");
	}

	@Override
	public IController<Specimen, Long> getIController() {
		return (IController<Specimen, Long>) AppContext.getApplicationContext().getBean("ControllerSpecimen");
	}
	
		
	public void next(ActionEvent actionEvent){}

	

	@Override
	public Object getModel() {
		return new SpecimenModel();
	}
	

	@Override
	public Specimen getDomain() {
		return new Specimen();
	}
	

	
	public Object loadCombos() {
		combos = new ComboSpecimen();
		/* 		
		List<String> list = (List<String>)getControllerList().getList(Estado.class);
		combos.setEstados(list);
		
		// TODO Auto-generated method stub*/
		return combos;
		
	}
	public Boolean getDefaultButton() {
		return false;
	}
	
	public ComboSpecimen getCombos() {
		return combos;
	}

	public void setCombos(ComboSpecimen combos) {
		this.combos = combos;
	}
	
	public String[] getCollunsTableSearch(){
		return new String[]{"Specimen.codigo","Specimen.nome","Specimen.cnpj","Specimen.status","endereco.endereco","endereco.cidade", "endereco.cep", "Specimen.email"};
	}
	
	public String[] getOrdersTableSearch() {
		return new String[]{"Specimen.nome"};
	}
	/*
	public void validCadastroCNPJ(String classValidator, Object valueValidator, String fieldDestination){
		super.validate(classValidator, valueValidator, fieldDestination);
		SpecimenModel pfm = (SpecimenModel) getObjectModel();
		String cnpj = pfm.getDadosEmpresa().getCnpj();
		if(!cnpj.equalsIgnoreCase("")){
			loadSpecimen(cnpj);
		}else{
			setObjectModel(getModel());
		}
		
	}*/

	private void loadSpecimen(String codigoCatalogo) {
		IController<Specimen, Long> controler = getIController();
		Specimen Specimen = new Specimen();
		Specimen.getCollect().setCodigoCatalogo(codigoCatalogo);
		List<SpecimenModel> list = null;
		try {
			list = (List<Specimen>) controler.getByFinder(Specimen, "Specimen.codigo", "Specimen.nome");
		} catch (ErrorException e) {
				treatException(e);
		}
		if((list != null)&&(list.size() != 0)){
			loadObjectTable(list.get(0));
		}
	}
	
	public boolean isReadOnlyCNPJ() {
		return readOnlyCNPJ;
	}

	public void setReadOnlyCNPJ(boolean readOnlyCNPJ) {
		this.readOnlyCNPJ = readOnlyCNPJ;
	}

	public Collector getCollector() {
		return collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}
	
	

}

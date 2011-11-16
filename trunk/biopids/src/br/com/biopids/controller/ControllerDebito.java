
package br.com.biopids.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;


import org.apache.commons.collections.set.CompositeSet.SetMutator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Debito;
import br.com.biopids.domain.EntityPersist;
import br.com.biopids.domain.Pessoa;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.PessoaJuridica;
import br.com.biopids.domain.Status;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.exception.TypeErrors;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerDebito;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.model.ParcelasModel;
import br.com.biopids.persistence.Criteria;
import br.com.biopids.persistence.DAODebito;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.persistence.GenericSearch;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.DateUtils;
import br.com.biopids.util.FactoreProperties;
import br.com.biopids.util.PropertiesLoader;


@Service("ControllerDebito")
public class ControllerDebito extends GenericController<Debito, Long> implements IControllerDebito<Debito, Long>{
	
	/**
	 * 
	 */
	private GenericSearch genericSearch;
	private IController<PessoaFisica, Long> controlePessoaFisica;
	private IController<PessoaJuridica, Long> controlePessoaJuridica;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;
	private String messageErro;
	private static final long serialVersionUID = -5520808066356852875L;
	public ControllerDebito(){
		super();
	}
	
	protected void setFields(Pessoa pessoa) {
		((PessoaFisica)pessoa).getCpf();
	}
	
	@Autowired(required=true)
	private DAODebito daoDebito;
	
	
	@Override
	public GenericDAO<Debito, Long> getDAO() {
		return this.daoDebito;
	}

	public DAODebito getDaoDebito() {
		return daoDebito;
	}

	public void setDaoDebito(DAODebito daoDebito) {
		this.daoDebito = daoDebito;
	}
	
	public void findDevedor(String n){}
	
	public Pessoa solvePessoa(Long id){
		controlePessoaFisica =  (IController<PessoaFisica, Long>) AppContext.getApplicationContext().getBean("ControllerPessoaFisica");
		try {
			pessoaFisica = getPessoaFisica(id);
			if (pessoaFisica == null) {
				controlePessoaJuridica = (IController<PessoaJuridica, Long>) AppContext.getApplicationContext().getBean("ControllerPessoaJuridica");
				pessoaJuridica = getPessoaJuridica(id);
				return pessoaJuridica;
			} else return pessoaFisica;
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public PessoaFisica getPessoaFisica(Long id) throws ErrorException{
		controlePessoaFisica =  (IController<PessoaFisica, Long>) AppContext.getApplicationContext().getBean("ControllerPessoaFisica");
		return controlePessoaFisica.getById(new PessoaFisica(), id);
	}
	public PessoaJuridica getPessoaJuridica(Long id) throws ErrorException{
		controlePessoaJuridica = (IController<PessoaJuridica, Long>) AppContext.getApplicationContext().getBean("ControllerPessoaJuridica");
		return controlePessoaJuridica.getById(new PessoaJuridica(), id);
	}	
	
	public PessoaJuridica findCnpj(String n) throws ErrorException{
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj(n);
		IController  controler = (IController) AppContext.getApplicationContext().getBean("ControllerPessoaJuridica");
		List<PessoaJuridica> list = null;
		list = controler.getByFinder(pessoaJuridica, "pessoajuridica.codigo", "pessoajuridica.cnpj" );
		if((list == null)||(list.size() == 0)){
			return null;
		}
		else {
		return getPessoaJuridica(list.get(0).getCodigo());
		}
	} 
	
	public PessoaFisica findCpf(String n) throws ErrorException{
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCpf(n);
		IController  controler = (IController) AppContext.getApplicationContext().getBean("ControllerPessoaFisica");
		List<PessoaFisica> list = null;
		list = controler.getByFinder(pessoaFisica, "pessoafisica.codigo", "pessoafisica.cpf" );
		if((list == null)||(list.size() == 0)){
			return null;
		}
		else {
		return getPessoaFisica(list.get(0).getCodigo());
		}
	} 
	
	public Object findField(Pessoa pessoa) throws ErrorException{
		List<?> list;
		if (pessoa instanceof PessoaJuridica){
			PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
			list = controlePessoaJuridica.getByFinder(pessoaJuridica,"pessoajuridica.codigo", "pessoajuridica.cnpj");
		} else {
			PessoaFisica pf = (PessoaFisica) pessoa;
			list = controlePessoaFisica.getByFinder(pf,"pessoafisica.codigo", "pessoafisica.cpf");
		}
		if((list == null)||(list.size() == 0)){
			return null;
		} else {
		return solvePessoa(((EntityPersist) list.get(0)).getCodigo());
		}
	}

	@Override
	public List<Debito> generateParcels(Debito debito) throws ErrorException{
		if(!validDebito(debito)){
			throw new ErrorException(TypeErrors.SEVERITY_INFO, getMessageErro());
		}
		List<Debito> debitos = new ArrayList<Debito>();
		debito.setStatus(Status.ATIVO);
		int parcelas = debito.getParcela();
		debitos.add(debito);
		for(int i= 1; i < parcelas; i++){
			Debito debito2 = debito.clone();
			debito2.setDataVencimento(DateUtils.incrementMonth(debito.getDataVencimento(), i));
			debitos.add(debito2);
		}
		
		return debitos;
	}

	public String getMessageErro() {
		return this.messageErro;
	}
	
	public void setMessageErro(String messageErro){
		this.messageErro = messageErro;
	}
	
	protected PropertiesLoader getPropertiesLoader() {
		// TODO Auto-generated method stub
		return FactoreProperties.loadPtbr();
	}
	
	private boolean validDebito(Debito debito) {
		return validDataCadastro(debito) && validDataVencimento(debito) && validDataVencimentoParcelas(debito);
	}

	private boolean validDataVencimento(Debito debito) {
		boolean result = true;
		System.out.println(debito.getDataVencimento().getTime());
		System.out.println((new Date()).getTime());
		if (debito.getDataVencimento().getTime() > (new Date()).getTime()){
			result = false;
			setMessageErro(properties.getValor("erro_debito_vencimento_maior_data_atual"));
		}
		return result;

	}

	private boolean validDataCadastro(Debito debito) {
		boolean result = true;
		if (debito.getDataCompra() == null)
			return result;
		if (debito.getDataCompra().getTime() > debito.getDataVencimento().getTime()){
			result = false;
			setMessageErro(properties.getValor("erro_debito_compra_maior_vencimento"));
		}
		return result;
	}
	
	private boolean validDataVencimentoParcelas(Debito debito){
		Date date = debito.getDataVencimento();
		date = DateUtils.incrementMonth(date, debito.getParcela());
		boolean result = true;
		if(date.getTime() > (new Date()).getTime()){
			result = false;
			setMessageErro(properties.getValor("erro_debito_data_ultima_parcela_a_mais"));
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void saveListDebito(List<Debito> debitos) throws ErrorException {
		if (!validDataVencimentoParcelas(debitos.get(0))){
			throw new ErrorException(TypeErrors.SEVERITY_INFO, getMessageErro());
		}
		for (Debito debito : debitos) {
			save(debito);
		}
		
	}
	
	
	
}

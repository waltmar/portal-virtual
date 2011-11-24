package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.PessoaJuridica;
import br.com.biopids.domain.Reino;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerReino;
import br.com.biopids.persistence.DAOReino;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerReino")
public class ControllerReino extends GenericController<Reino, Long> implements IControllerReino<Reino, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Filo, Long> controllerFilo;
	
	public ControllerReino(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOReino daoReino;
	
	@Override
	public GenericDAO<Reino, Long> getDAO() {
		return this.daoReino;
	}

	public DAOReino getDaoReino() {
		return daoReino;
	}

	public void setDaoReino(DAOReino daoReino) {
		this.daoReino = daoReino;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Reino reino, List<Reino> list){
		
		int size = list.size();
		boolean result = true;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Reino) list.get(i)).getValor();
				String valor2 = reino.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isFather(Reino reino) throws ErrorException{
		controllerFilo =  (IController<Filo, Long>) AppContext.getApplicationContext().getBean("ControllerFilo");
		Filo filo = new Filo();
		filo.setReino(reino);
		List<Filo> list= controllerFilo.getByFinder(filo, new String[]{"filo.reino", "filo.codigo"});
		if (!list.isEmpty())
			return true;
		else 
		return false;
	}
	
	public boolean isValid(Reino reino){
		if (reino.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Reino reino){
		if (reino.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Familia;

import br.com.biopids.domain.Ordem;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerOrdem;
import br.com.biopids.persistence.DAOOrdem;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerOrdem")
public class ControllerOrdem extends GenericController<Ordem, Long> implements IControllerOrdem<Ordem, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Familia, Long> controllerFamilia;
	
	public ControllerOrdem(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOOrdem daoOrdem;
	
	@Override
	public GenericDAO<Ordem, Long> getDAO() {
		return this.daoOrdem;
	}

	public DAOOrdem getDaoOrdem() {
		return daoOrdem;
	}

	public void setDaoOrdem(DAOOrdem daoOrdem) {
		this.daoOrdem = daoOrdem;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Ordem ordem, List<Ordem> list){
		
		int size = list.size();
		boolean result = true;
		if (ordem.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Ordem) list.get(i)).getValor();
				String valor2 = ordem.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isFather(Ordem ordem) throws ErrorException{
		controllerFamilia =  (IController<Familia, Long>) AppContext.getApplicationContext().getBean("ControllerFamilia");
		Familia familia = new Familia();
		familia.setOrdem(ordem);
		List<Familia> list= controllerFamilia.getByFinder(familia, new String[]{"familia.ordem", "familia.codigo"});
		if (!list.isEmpty())
			return true;
		else 
		return false;
	}
	
	public boolean isValid(Ordem ordem){
		if (ordem.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Ordem ordem){
		if (ordem.getValor() == null) return false;
		else return true;
		
	}
			
	
}

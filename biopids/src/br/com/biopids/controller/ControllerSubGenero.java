package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.SubGenero;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerSubGenero;
import br.com.biopids.persistence.DAOSubGenero;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerSubGenero")
public class ControllerSubGenero extends GenericController<SubGenero, Long> implements IControllerSubGenero<SubGenero, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;

	
	public ControllerSubGenero(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOSubGenero daoSubGenero;
	
	@Override
	public GenericDAO<SubGenero, Long> getDAO() {
		return this.daoSubGenero;
	}

	public DAOSubGenero getDaoSubGenero() {
		return daoSubGenero;
	}

	public void setDaoSubGenero(DAOSubGenero daoSubGenero) {
		this.daoSubGenero = daoSubGenero;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(SubGenero subGenero, List<SubGenero> list){
		
		int size = list.size();
		boolean result = true;
		if (subGenero.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((SubGenero) list.get(i)).getValor();
				String valor2 = subGenero.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(SubGenero subGenero){
		if (subGenero.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(SubGenero subGenero){
		if (subGenero.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.SubOrdem;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerSubOrdem;
import br.com.biopids.persistence.DAOSubOrdem;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerSubOrdem")
public class ControllerSubOrdem extends GenericController<SubOrdem, Long> implements IControllerSubOrdem<SubOrdem, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;

	
	public ControllerSubOrdem(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOSubOrdem daoSubOrdem;
	
	@Override
	public GenericDAO<SubOrdem, Long> getDAO() {
		return this.daoSubOrdem;
	}

	public DAOSubOrdem getDaoSubOrdem() {
		return daoSubOrdem;
	}

	public void setDaoSubOrdem(DAOSubOrdem daoSubOrdem) {
		this.daoSubOrdem = daoSubOrdem;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(SubOrdem subOrdem, List<SubOrdem> list){
		
		int size = list.size();
		boolean result = true;
		if (subOrdem.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((SubOrdem) list.get(i)).getValor();
				String valor2 = subOrdem.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(SubOrdem subOrdem){
		if (subOrdem.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(SubOrdem subOrdem){
		if (subOrdem.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

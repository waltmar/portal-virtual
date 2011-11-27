package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.SubClasse;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerSubClasse;
import br.com.biopids.persistence.DAOSubClasse;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerSubClasse")
public class ControllerSubClasse extends GenericController<SubClasse, Long> implements IControllerSubClasse<SubClasse, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;

	
	public ControllerSubClasse(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOSubClasse daoSubClasse;
	
	@Override
	public GenericDAO<SubClasse, Long> getDAO() {
		return this.daoSubClasse;
	}

	public DAOSubClasse getDaoSubClasse() {
		return daoSubClasse;
	}

	public void setDaoSubClasse(DAOSubClasse daoSubClasse) {
		this.daoSubClasse = daoSubClasse;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(SubClasse subClasse, List<SubClasse> list){
		
		int size = list.size();
		boolean result = true;
		if (subClasse.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((SubClasse) list.get(i)).getValor();
				String valor2 = subClasse.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(SubClasse subClasse){
		if (subClasse.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(SubClasse subClasse){
		if (subClasse.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

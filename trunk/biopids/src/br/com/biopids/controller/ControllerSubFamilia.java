package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.SubFamilia;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerSubFamilia;
import br.com.biopids.persistence.DAOSubFamilia;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerSubFamilia")
public class ControllerSubFamilia extends GenericController<SubFamilia, Long> implements IControllerSubFamilia<SubFamilia, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;

	
	public ControllerSubFamilia(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOSubFamilia daoSubFamilia;
	
	@Override
	public GenericDAO<SubFamilia, Long> getDAO() {
		return this.daoSubFamilia;
	}

	public DAOSubFamilia getDaoSubFamilia() {
		return daoSubFamilia;
	}

	public void setDaoSubFamilia(DAOSubFamilia daoSubFamilia) {
		this.daoSubFamilia = daoSubFamilia;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(SubFamilia subFamilia, List<SubFamilia> list){
		
		int size = list.size();
		boolean result = true;
		if (subFamilia.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((SubFamilia) list.get(i)).getValor();
				String valor2 = subFamilia.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(SubFamilia subFamilia){
		if (subFamilia.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(SubFamilia subFamilia){
		if (subFamilia.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

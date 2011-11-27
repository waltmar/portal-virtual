package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.Fenologia;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerFenologia;
import br.com.biopids.persistence.DAOFenologia;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerFenologia")
public class ControllerFenologia extends GenericController<Fenologia, Long> implements IControllerFenologia<Fenologia, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Filo, Long> controllerFilo;
	
	public ControllerFenologia(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOFenologia daoFenologia;
	
	@Override
	public GenericDAO<Fenologia, Long> getDAO() {
		return this.daoFenologia;
	}

	public DAOFenologia getDaoFenologia() {
		return daoFenologia;
	}

	public void setDaoFenologia(DAOFenologia daoFenologia) {
		this.daoFenologia = daoFenologia;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Fenologia fenologia, List<Fenologia> list){
		
		int size = list.size();
		boolean result = true;
		if (fenologia.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Fenologia) list.get(i)).getValor();
				String valor2 = fenologia.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(Fenologia fenologia){
		if (fenologia.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Fenologia fenologia){
		if (fenologia.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

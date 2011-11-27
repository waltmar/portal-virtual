package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.Metodo;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerMetodo;
import br.com.biopids.persistence.DAOMetodo;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerMetodo")
public class ControllerMetodo extends GenericController<Metodo, Long> implements IControllerMetodo<Metodo, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;

	
	public ControllerMetodo(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOMetodo daoMetodo;
	
	@Override
	public GenericDAO<Metodo, Long> getDAO() {
		return this.daoMetodo;
	}

	public DAOMetodo getDaoMetodo() {
		return daoMetodo;
	}

	public void setDaoMetodo(DAOMetodo daoMetodo) {
		this.daoMetodo = daoMetodo;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Metodo metodo, List<Metodo> list){
		
		int size = list.size();
		boolean result = true;
		if (metodo.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Metodo) list.get(i)).getValor();
				String valor2 = metodo.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(Metodo metodo){
		if (metodo.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Metodo metodo){
		if (metodo.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

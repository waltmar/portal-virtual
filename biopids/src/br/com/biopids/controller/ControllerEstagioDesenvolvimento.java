package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.EstagioDesenvolvimento;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerEstagioDesenvolvimento;
import br.com.biopids.persistence.DAOEstagioDesenvolvimento;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerEstagioDesenvolvimento")
public class ControllerEstagioDesenvolvimento extends GenericController<EstagioDesenvolvimento, Long> implements IControllerEstagioDesenvolvimento<EstagioDesenvolvimento, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Filo, Long> controllerFilo;
	
	public ControllerEstagioDesenvolvimento(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOEstagioDesenvolvimento daoEstagioDesenvolvimento;
	
	@Override
	public GenericDAO<EstagioDesenvolvimento, Long> getDAO() {
		return this.daoEstagioDesenvolvimento;
	}

	public DAOEstagioDesenvolvimento getDaoEstagioDesenvolvimento() {
		return daoEstagioDesenvolvimento;
	}

	public void setDaoEstagioDesenvolvimento(DAOEstagioDesenvolvimento daoEstagioDesenvolvimento) {
		this.daoEstagioDesenvolvimento = daoEstagioDesenvolvimento;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(EstagioDesenvolvimento metodo, List<EstagioDesenvolvimento> list){
		
		int size = list.size();
		boolean result = true;
		if (metodo.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((EstagioDesenvolvimento) list.get(i)).getValor();
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
	
	public boolean isValid(EstagioDesenvolvimento metodo){
		if (metodo.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(EstagioDesenvolvimento metodo){
		if (metodo.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

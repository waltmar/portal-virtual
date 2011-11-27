package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.MassaDagua;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerMassaDagua;
import br.com.biopids.persistence.DAOMassaDagua;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerMassaDagua")
public class ControllerMassaDagua extends GenericController<MassaDagua, Long> implements IControllerMassaDagua<MassaDagua, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Filo, Long> controllerFilo;
	
	public ControllerMassaDagua(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOMassaDagua daoMassaDagua;
	
	@Override
	public GenericDAO<MassaDagua, Long> getDAO() {
		return this.daoMassaDagua;
	}

	public DAOMassaDagua getDaoMassaDagua() {
		return daoMassaDagua;
	}

	public void setDaoMassaDagua(DAOMassaDagua daoMassaDagua) {
		this.daoMassaDagua = daoMassaDagua;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(MassaDagua massaDagua, List<MassaDagua> list){
		
		int size = list.size();
		boolean result = true;
		if (massaDagua.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((MassaDagua) list.get(i)).getValor();
				String valor2 = massaDagua.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(MassaDagua massaDagua){
		if (massaDagua.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(MassaDagua massaDagua){
		if (massaDagua.getValor() == null) return false;
		else return true;
		
	}

	@Override
	public boolean isFather(MassaDagua massaDagua) throws ErrorException {
		// TODO Auto-generated method stub
		return false;
	}
			
	
	
	
	
}

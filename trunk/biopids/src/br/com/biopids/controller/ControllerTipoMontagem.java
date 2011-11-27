package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.TipoMontagem;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerTipoMontagem;
import br.com.biopids.persistence.DAOTipoMontagem;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerTipoMontagem")
public class ControllerTipoMontagem extends GenericController<TipoMontagem, Long> implements IControllerTipoMontagem<TipoMontagem, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Filo, Long> controllerFilo;
	
	public ControllerTipoMontagem(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOTipoMontagem daoTipoMontagem;
	
	@Override
	public GenericDAO<TipoMontagem, Long> getDAO() {
		return this.daoTipoMontagem;
	}

	public DAOTipoMontagem getDaoTipoMontagem() {
		return daoTipoMontagem;
	}

	public void setDaoTipoMontagem(DAOTipoMontagem daoTipoMontagem) {
		this.daoTipoMontagem = daoTipoMontagem;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(TipoMontagem tipoMontagem, List<TipoMontagem> list){
		
		int size = list.size();
		boolean result = true;
		if (tipoMontagem.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((TipoMontagem) list.get(i)).getValor();
				String valor2 = tipoMontagem.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(TipoMontagem tipoMontagem){
		if (tipoMontagem.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(TipoMontagem tipoMontagem){
		if (tipoMontagem.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

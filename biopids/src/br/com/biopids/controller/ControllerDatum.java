package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Filo;

import br.com.biopids.domain.Datum;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerDatum;
import br.com.biopids.persistence.DAODatum;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerDatum")
public class ControllerDatum extends GenericController<Datum, Long> implements IControllerDatum<Datum, Long>{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -5520808066356852875L;

	
	public ControllerDatum(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAODatum daoDatum;
	
	@Override
	public GenericDAO<Datum, Long> getDAO() {
		return this.daoDatum;
	}

	public DAODatum getDaoDatum() {
		return daoDatum;
	}

	public void setDaoDatum(DAODatum daoDatum) {
		this.daoDatum = daoDatum;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Datum datum, List<Datum> list){
		
		int size = list.size();
		boolean result = true;
		if (datum.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Datum) list.get(i)).getValor();
				String valor2 = datum.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isValid(Datum datum){
		if (datum.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Datum datum){
		if (datum.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

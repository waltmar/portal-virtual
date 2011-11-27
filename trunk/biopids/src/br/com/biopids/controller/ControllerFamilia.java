package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Genero;

import br.com.biopids.domain.Familia;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerFamilia;
import br.com.biopids.persistence.DAOFamilia;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerFamilia")
public class ControllerFamilia extends GenericController<Familia, Long> implements IControllerFamilia<Familia, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Genero, Long> controllerGenero;
	
	public ControllerFamilia(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOFamilia daoFamilia;
	
	@Override
	public GenericDAO<Familia, Long> getDAO() {
		return this.daoFamilia;
	}

	public DAOFamilia getDaoFamilia() {
		return daoFamilia;
	}

	public void setDaoFamilia(DAOFamilia daoFamilia) {
		this.daoFamilia = daoFamilia;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Familia familia, List<Familia> list){
		
		int size = list.size();
		boolean result = true;
		if (familia.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Familia) list.get(i)).getValor();
				String valor2 = familia.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isFather(Familia familia) throws ErrorException{
		controllerGenero =  (IController<Genero, Long>) AppContext.getApplicationContext().getBean("ControllerGenero");
		Genero genero = new Genero();
		genero.setFamilia(familia);
		List<Genero> list= controllerGenero.getByFinder(genero, new String[]{"genero.familia", "genero.codigo"});
		if (!list.isEmpty())
			return true;
		else 
		return false;
	}
	
	public boolean isValid(Familia familia){
		if (familia.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Familia familia){
		if (familia.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

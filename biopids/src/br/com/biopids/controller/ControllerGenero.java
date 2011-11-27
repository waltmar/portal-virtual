package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.EpEspecifico;

import br.com.biopids.domain.Genero;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerGenero;
import br.com.biopids.persistence.DAOGenero;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerGenero")
public class ControllerGenero extends GenericController<Genero, Long> implements IControllerGenero<Genero, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<EpEspecifico, Long> controllerEpEspecifico;
	
	public ControllerGenero(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOGenero daoGenero;
	
	@Override
	public GenericDAO<Genero, Long> getDAO() {
		return this.daoGenero;
	}

	public DAOGenero getDaoGenero() {
		return daoGenero;
	}

	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Genero genero, List<Genero> list){
		
		int size = list.size();
		boolean result = true;
		if (genero.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Genero) list.get(i)).getValor();
				String valor2 = genero.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isFather(Genero genero) throws ErrorException{
		controllerEpEspecifico =  (IController<EpEspecifico, Long>) AppContext.getApplicationContext().getBean("ControllerEpEspecifico");
		EpEspecifico epEspecifico = new EpEspecifico();
		epEspecifico.setGenero(genero);
		List<EpEspecifico> list= controllerEpEspecifico.getByFinder(epEspecifico, new String[]{"epespecifico.genero", "epespecifico.codigo"});
		if (!list.isEmpty())
			return true;
		else 
		return false;
	}
	
	public boolean isValid(Genero genero){
		if (genero.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Genero genero){
		if (genero.getValor() == null) return false;
		else return true;
		
	}
			
	
	
	
	
}

package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Ordem;

import br.com.biopids.domain.Classe;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerClasse;
import br.com.biopids.persistence.DAOClasse;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerClasse")
public class ControllerClasse extends GenericController<Classe, Long> implements IControllerClasse<Classe, Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Ordem, Long> controllerOrdem;
	
	public ControllerClasse(){
		super();
	}
	
	
	@Autowired(required=true)
	private DAOClasse daoClasse;
	
	@Override
	public GenericDAO<Classe, Long> getDAO() {
		return this.daoClasse;
	}

	public DAOClasse getDaoClasse() {
		return daoClasse;
	}

	public void setDaoClasse(DAOClasse daoClasse) {
		this.daoClasse = daoClasse;
	}
	//-----------------validacoes------------->
	
	public boolean isNew(Classe classe, List<Classe> list){
		
		int size = list.size();
		boolean result = true;
		if (classe.getCodigo() != null)
			return result;
		if (size!= 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Classe) list.get(i)).getValor();
				String valor2 = classe.getValor();
				valor2= valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}
	
	public boolean isFather(Classe classe) throws ErrorException{
		controllerOrdem =  (IController<Ordem, Long>) AppContext.getApplicationContext().getBean("ControllerOrdem");
		Ordem ordem = new Ordem();
		ordem.setClasse(classe);
		List<Ordem> list= controllerOrdem.getByFinder(ordem, new String[]{"ordem.classe", "ordem.codigo"});
		if (!list.isEmpty())
			return true;
		else 
		return false;
	}
	
	public boolean isValid(Classe classe){
		if (classe.getValor().length() < 3)
			return false;
		else return true;
	}
	
	public boolean isNotNull(Classe classe){
		if (classe.getValor() == null) return false;
		else return true;
		
	}

}

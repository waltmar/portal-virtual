package br.com.biopids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopids.domain.Classe;
import br.com.biopids.domain.Filo;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.interfaces.IControllerFilo;
import br.com.biopids.persistence.DAOFilo;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.provider.AppContext;

@Service("ControllerFilo")
public class ControllerFilo extends GenericController<Filo, Long> implements
		IControllerFilo<Filo, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	private IController<Classe, Long> controllerClasse;

	public ControllerFilo() {
		super();
	}

	@Autowired(required = true)
	private DAOFilo daoFilo;

	@Override
	public GenericDAO<Filo, Long> getDAO() {
		return this.daoFilo;
	}

	public DAOFilo getDaoFilo() {
		return daoFilo;
	}

	public void setDaoFilo(DAOFilo daoFilo) {
		this.daoFilo = daoFilo;
	}

	// -----------------validacoes------------->

	public boolean isNew(Filo Filo, List<Filo> list) {

		int size = list.size();
		boolean result = true;
		if (size != 0) {
			for (int i = 0; i < size; i++) {
				Long pai1 = ((Filo) list.get(i)).getReino().getCodigo();
				Long pai2 = Filo.getReino().getCodigo();
				if (pai1.intValue() == pai2.intValue()) {

					String valor1 = ((Filo) list.get(i)).getValor();
					String valor2 = Filo.getValor();
					valor2 = valor2.toUpperCase();
					if (valor1.equals(valor2)) {
						result = false;
						break;
					}
				}
			}

		}
		return result;
	}

	public boolean isFather(Filo Filo) throws ErrorException {
		controllerClasse = (IController<Classe, Long>) AppContext
				.getApplicationContext().getBean("ControllerClasse");
		Classe classe = new Classe();
		classe.setFilo(Filo);
		List<Classe> list = controllerClasse.getByFinder(classe, new String[] {
				"classe.filo", "classe.codigo" });
		if (!list.isEmpty())
			return true;
		else
			return false;
	}

	public boolean isValid(Filo Filo) {
		if (Filo.getValor().length() < 3 )
			return false;
		else
			return true;
	}

	public boolean isNotNull(Filo Filo) {
		if (Filo.getValor() == null || (Filo.getReino() == null))
			return false;
		else
			return true;

	}

}

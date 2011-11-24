package br.com.biopids.validator;

import java.util.List;

import br.com.biopids.domain.Filo;
import br.com.biopids.domain.Reino;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.provider.AppContext;

public class BasicValidator {
	
	private IController<Filo, Long> controllerFilo;
	
	public boolean isNew(Reino reino, List<Reino> list) {

		int size = list.size();
		boolean result = true;
		if (size != 0) {
			for (int i = 0; i < size; i++) {
				String valor1 = ((Reino) list.get(i)).getValor();
				String valor2 = reino.getValor();
				valor2 = valor2.toUpperCase();
				if (valor1.equals(valor2)) {
					result = false;
					break;
				}
			}

		}
		return result;
	}

	public boolean isFather(Reino reino) throws ErrorException {
		controllerFilo = (IController<Filo, Long>) AppContext
				.getApplicationContext().getBean("ControllerFilo");
		Filo filo = new Filo();
		filo.setReino(reino);
		List<Filo> list = controllerFilo.getByFinder(filo, new String[] {
				"filo.reino", "filo.codigo" });
		if (!list.isEmpty())
			return true;
		else
			return false;
	}

	public boolean isValid(Reino reino) {
		if (reino.getValor().length() < 3)
			return false;
		else
			return true;
	}

	public boolean isNotNull(Reino reino) {
		if (reino.getValor() == null)
			return false;
		else
			return true;

	}

}

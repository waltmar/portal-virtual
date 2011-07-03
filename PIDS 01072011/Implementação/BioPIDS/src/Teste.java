import java.util.ArrayList;

import controle.Controle;
import itensParaPersistencia.Taxonomia;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controle ctrl = new Controle();
		
		Taxonomia reino = new Taxonomia();
		Taxonomia aux;
		reino.setNomeTabela("Reino");
		reino.setId("10");
	
		aux = ctrl.buscarItem(reino);
		System.out.println(aux.getNome());
	}

}

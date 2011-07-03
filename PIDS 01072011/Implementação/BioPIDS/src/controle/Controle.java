package controle;

import java.util.ArrayList;

import itensParaPersistencia.Taxonomia;
import persistencia.Persistencia;

public class Controle {

	public void inserirItem(Taxonomia t) {

		try {
			Persistencia persist = new Persistencia();
			persist.inserirItem(t);
		} catch (Exception e) {
		}

	}

	public void excluirItem(Taxonomia t) {

		try {
			Persistencia persist = new Persistencia();
			persist.excluirItem(t);
		} catch (Exception e) {
		}
	}

	public void atualizarItem(Taxonomia t) {

		try {
			Persistencia persist = new Persistencia();
			persist.atualizarItem(t);
		} catch (Exception e) {
		}

	}

	public Taxonomia buscarItem(Taxonomia t) {

		Taxonomia t1 = new Taxonomia();
		try {
			Persistencia persist = new Persistencia();
			t1 = persist.buscarItem(t);

		} catch (Exception e) {
		}
		return t1;
	}

	public Taxonomia buscarPorNome(Taxonomia t) {

		Taxonomia t1 = new Taxonomia();
		try {
			Persistencia persist = new Persistencia();
			t1 = persist.buscarPorNome(t);

		} catch (Exception e) {
		}
		return t1;
	}

	public ArrayList<Taxonomia> todosOsItens(Taxonomia t) {

		ArrayList<Taxonomia> lista = new ArrayList<Taxonomia>();
		try {
			Persistencia persist = new Persistencia();
			lista = persist.todosOsItens(t);

		} catch (Exception e) {
		}
		return lista;
	}

	public Taxonomia buscarPorPai(Taxonomia t) {

		Taxonomia t1 = new Taxonomia();
		try {
			Persistencia persist = new Persistencia();
			t1 = persist.buscarPorPai(t);

		} catch (Exception e) {
		}
		return t1;
	}

}

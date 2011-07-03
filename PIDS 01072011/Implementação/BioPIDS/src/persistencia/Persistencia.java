package persistencia;

import itensParaPersistencia.Taxonomia;
import java.sql.*;
import java.util.ArrayList;
import persistencia.PersistenciaGenerica;

public class Persistencia extends PersistenciaGenerica {

	public void inserirItem(Taxonomia t) throws SQLException {

		iniciarConexao();

		query = "INSERT INTO " + t.NomeTabela() + " (nome, pai) VALUES(?, ?)";
		stmt = con.prepareStatement(query);
		stmt.setString(1, t.getNome());
		stmt.setInt(2, Integer.parseInt(t.getPai()));

		stmt.executeUpdate();

		encerrarConexao();
	}

	public void excluirItem(Taxonomia t) throws SQLException {

		iniciarConexao();

		query = "DELETE FROM " + t.NomeTabela() + " WHERE id_item = ? ";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(t.Id()));
		stmt.executeUpdate();

		encerrarConexao();

	}
	
	public void atualizarItem(Taxonomia t) throws SQLException {

		iniciarConexao();

		query = "INSERT INTO " + t.NomeTabela() + " (id_item, nome, pai) VALUES(?, ?, ?)";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(t.Id()));
		stmt.setString(2, t.getNome());
		stmt.setInt(3, Integer.parseInt(t.getPai()));

		stmt.executeUpdate();

		encerrarConexao();
	}

	public Taxonomia buscarItem(Taxonomia t) throws SQLException {

		iniciarConexao();

		query = "SELECT * FROM " + t.NomeTabela() + " WHERE id_item = ? ";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(t.Id()));
		res = stmt.executeQuery();
		Taxonomia t1 = new Taxonomia();
		while (res.next()) {

			t1.setId(Integer.toString(res.getInt("id_item")));
			t1.setNome(res.getString("nome"));
			t1.setPai(Integer.toString(res.getInt("pai")));
		}
		encerrarConexao();

		return t1;
	}
	public Taxonomia buscarPorNome(Taxonomia t) throws SQLException {

		iniciarConexao();

		query = "SELECT * FROM " + t.NomeTabela() + " WHERE nome = ? ";
		stmt = con.prepareStatement(query);
		stmt.setString(1, t.getNome());
		res = stmt.executeQuery();
		Taxonomia t1 = new Taxonomia();
		while (res.next()) {

			t1.setId(Integer.toString(res.getInt("id_item")));
			t1.setNome(res.getString("nome"));
			t1.setPai(Integer.toString(res.getInt("pai")));
		}
		encerrarConexao();

		return t1;
	}

	public ArrayList<Taxonomia> todosOsItens(Taxonomia t) throws SQLException {

		iniciarConexao();

		query = "Select * from " + t.NomeTabela();
		ArrayList<Taxonomia> lista = new ArrayList<Taxonomia>();
		stmt = con.prepareStatement(query);
		res = stmt.executeQuery();

		while (res.next()) {
			Taxonomia t1 = new Taxonomia();
			t1.setId(Integer.toString(res.getInt("id_item")));
			t1.setNome(res.getString("nome"));
			t1.setPai(Integer.toString(res.getInt("pai")));
			lista.add(t1);
		}

		encerrarConexao();

		return lista;
	}

	public Taxonomia buscarPorPai(Taxonomia t) throws SQLException {

		iniciarConexao();

		query = "SELECT * FROM " + t.NomeTabela() + " WHERE pai = ? ";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(t.Id()));
		res = stmt.executeQuery();
		Boolean resp = false;
		Taxonomia t1 = new Taxonomia();
		if (res.next()) {

			t1.setId(Integer.toString(res.getInt("id_item")));
			t1.setNome(res.getString("nome"));
			t1.setPai(Integer.toString(res.getInt("pai")));
		} else
			resp = null;
		encerrarConexao();
		if (resp == null) {
			return null;
		}
		return t1;

	}

}

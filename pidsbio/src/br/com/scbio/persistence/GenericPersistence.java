package br.com.scbio.persistence;

import java.beans.Statement;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.scbio.conection.ConectionSqlServer;
import br.com.scbio.domain.EntityPersist;
import java.lang.reflect.InvocationTargetException;

public class GenericPersistence<T extends EntityPersist> {

	protected Connection con;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet res = null;
	private String query;
	protected CreateQuery<?> createQuery;

	public GenericPersistence() {
		// createQuery = new CreateQuery<T>();
	}

	// --------------------------------------------------------------------//
	public void initConect() throws SQLException {

		con = ConectionSqlServer.ConectSQL();

	}

	public void endConect() throws SQLException {

		con.close();
		stmt.close();
	}

	// --------------------------------------------------------------------//

	public void save(T entity) throws SQLException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		initConect();

		CreateQuery<EntityPersist> createQuery = new CreateQuery<EntityPersist>();
		query = createQuery.CreateQuerySave((EntityPersist) entity);
		stmt = ((java.sql.Connection) con).prepareStatement(query);

		stmt.executeUpdate();

		endConect();

	}

	public void update(T entity) throws SQLException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		initConect();

		CreateQuery<EntityPersist> createQuery = new CreateQuery<EntityPersist>();
		query = createQuery.CreateQueryUpdate((EntityPersist) entity);
		stmt = ((java.sql.Connection) con).prepareStatement(query);

		stmt.executeUpdate();

		endConect();

	}

	public void delete(T entity) throws SQLException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		initConect();

		CreateQuery<EntityPersist> createQuery = new CreateQuery<EntityPersist>();
		query = createQuery.CreateQueryDelete((EntityPersist) entity);
		stmt = ((java.sql.Connection) con).prepareStatement(query);

		stmt.executeUpdate();

		endConect();

	}
	

	public EntityPersist getById(T entity) throws SQLException,
			ClassNotFoundException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException, NoSuchMethodException, SecurityException {

		initConect();

		CreateQuery<EntityPersist> createQuery = new CreateQuery<EntityPersist>();
		query = createQuery.CreateQueryGetById((EntityPersist) entity);
		stmt = ((java.sql.Connection) con).prepareStatement(query);

		res = stmt.executeQuery();

		Class<?> cls = entity.getClass();
		
		ArrayList<String> list = new ArrayList<String>();
		list= createQuery.getSets(entity);

		EntityPersist e;
		e = (EntityPersist) cls.newInstance();

		while (res.next()) {
			
			
			for (int i = 0; i< list.size(); i++) {
				
				Object aux = res.getObject((list.get(i+1).substring(3)).toLowerCase());
				
				Method m = cls.getMethod(list.get(i), cls);
				m.invoke(e, aux);
			
			}
		}

		endConect();

		return e;
	}

	public EntityPersist buscarPorNome(EntityPersist t) throws SQLException {

		initConect();

		// query = "SELECT * FROM " + t.NomeTabela() + " WHERE nome = ? ";
		// stmt = con.prepareStatement(query);
		// stmt.setString(1, t.getNome());
		// res = stmt.executeQuery();
		// EntityPersist t1 = new EntityPersist();
		while (res.next()) {

			// t1.setId(Integer.toString(res.getInt("id_item")));
			// t1.setNome(res.getString("nome"));
			// t1.setPai(Integer.toString(res.getInt("pai")));
		}
		endConect();

		return t;
	}

	public ArrayList<EntityPersist> todosOsItens(EntityPersist t)
			throws SQLException {

		initConect();

		query = "Select * from " + t;
		ArrayList<EntityPersist> lista = new ArrayList<EntityPersist>();
		stmt = ((java.sql.Connection) con).prepareStatement(query);
		res = stmt.executeQuery();

		while (res.next()) {
			EntityPersist t1 = new EntityPersist();
			// t1.setId(Integer.toString(res.getInt("id_item")));
			// t1.setNome(res.getString("nome"));
			// t1.setPai(Integer.toString(res.getInt("pai")));
			lista.add(t1);
		}

		endConect();

		return lista;
	}

}
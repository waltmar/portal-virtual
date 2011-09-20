package br.com.scbio.persistence;

import java.beans.Statement;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.scbio.conection.ConectionSqlServer;
import br.com.scbio.domain.EntityPersist;
import java.lang.reflect.InvocationTargetException;

import com.sun.corba.se.pept.transport.Connection;



public class GenericPersistence<T extends EntityPersist>  {
	
	private Connection con;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet res = null;
	private String query;	
	protected CreateQuery<?> createQuery;
	
	
	public GenericPersistence(){
		//createQuery = new CreateQuery<T>();
	}
//--------------------------------------------------------------------//	
	public void initConect () throws SQLException {  
		
		con = (Connection) ConectionSqlServer.ConectSQL();  

	}
	    
	public void endConect() throws SQLException {
		 	
		con.close();
		stmt.close();
	} 
//--------------------------------------------------------------------//
	
public void save(T entity){
		
	initConect();
	EntityPersist entityPersist;
	query = createQuery.CreateQuerySave(entity);
	stmt = ((java.sql.Connection) con).prepareStatement(query);
	
	stmt.executeUpdate();

	endConect();

	}

public void update(T entity){
	
	initConect();

	query = createQuery.CreateQuerUpdate(entity);
	stmt = ((java.sql.Connection) con).prepareStatement(query);
	
	stmt.executeUpdate();

	endConect();

	}

public void delete(T entity) throws SQLException {

	initConect();

	query = createQuery.CriateQueryDelete(entity);
	stmt = con.prepareStatement(query);
	stmt.executeUpdate();

	endConect();

}
	
public EntityPersist getById(T entity) throws SQLException {

	initConect();
	
	query = createQuery.CriateQueryGetById(entity);
	stmt = con.prepareStatement(query);
	
	res = stmt.executeQuery();
	
	Class<?> cls = getClass(entity);
	Method listMethods[] = cls.getMethods();
	
	EntityPersist e = new EntityPersist();
	
	while (res.next()) {
		for (int i = 0; i < listMethods.length  ; i++) {
			Method m = (listMethods[i]);
			if (m.getName().contains("set") ) {
				m.invoke(entity, res.getObject(m.getName());
			}
			e.setId_item(res.getFloat("id_item"));
		
	}
	endConect();

	return e;
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

}	
package br.com.scbio.persistence;
import java.lang.reflect.Method;
import java.sql.*;

import br.com.scbio.conection.ConectionSqlServer;


public class GenericPersistence<T> {
	
	private Connection con;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet res = null;
	private String query;	    

//--------------------------------------------------------------------//	
	public void initConect () throws SQLException {  
		
		con = ConectionSqlServer.ConectSQL();  

	}
	    
	public void endConect() throws SQLException {
		 	
		con.close();
		stmt.close();
	} 
//--------------------------------------------------------------------//
	
public String save(T entity){
		
		String query = "INSERT INTO ";
		query = query + entity.getClass().getSimpleName();//insere o nome da tabela 
		query = query + " VALUES (";
		try {  
			
			Class<?> cls = Class.forName(entity.getClass().getSimpleName());	
			Method listaMetodos[] = cls.getMethods(); //busca todos os métodos da classe
			
			for (int i = 0; i < listaMetodos.length; i++) {
				 
				Method m = (listaMetodos[i]);  
				if (m.getName().contains("get") ) {// interessa somente os gets para pegar os atributos 		
					
						query = query + (String) m.invoke(entity, new Object[0]) ;// armazena o primeiro atributo da classe
						query = query +", ";
				}
			} 
			
			}catch (Exception e) {}
			
			query = query.substring(0, query.length()-2);//retira a ultima vírgula 
			query = query + ")";
		return query; 
	
	
	}
	
	

}	
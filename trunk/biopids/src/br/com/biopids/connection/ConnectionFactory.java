package br.com.biopids.connection;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactory {
	private static String url = "jdbc:postgresql://financeiro.cdlanapolis.com.br/solutions_financeiro";
	private static String usuario = "solutions.financeiro";
	private static String senha = "#sol_fin";
		
	public static Connection getConnection() throws Exception{
		Context initCtx = (Context) new InitialContext();
		Object obj = initCtx.lookup("java:/comp/env/jdbc/sistemacobranca");
	       DataSource dt = (DataSource) obj;
		Connection connection = dt.getConnection();
        return connection;
	}
}




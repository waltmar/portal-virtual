package persistencia;
import java.sql.*;
import Conexoes.ConexaoSqlServer;

public class PersistenciaGenerica {
	
	protected Connection con;
	protected PreparedStatement stmt;
	protected Statement st;
	protected ResultSet res = null;
	protected String query;	    

//--------------------------------------------------------------------//	
	public void iniciarConexao () throws SQLException {  
		
		con = ConexaoSqlServer.ConexaoSQL();  

	}
	    
	public void encerrarConexao() throws SQLException {
		 	
		con.close();
		stmt.close();
	} 
//--------------------------------------------------------------------//

}	
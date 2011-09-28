package br.com.scbio.conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionSqlServer {  
  
    public static Connection ConectSQL() throws SQLException {  
          
        try {  
           
            String driver ="net.sourceforge.jtds.jdbc.Driver";
			String url = "jdbc:jtds:sqlserver://localhost:1433/bio";
			String usuario = "cally.af";
			String senha = "cally";
			Class.forName(driver); 

			
            return DriverManager.getConnection(url,usuario,senha);
        }
        catch (ClassNotFoundException e) {  
            throw new SQLException(e.getMessage());  
        }         
    }  
    
}
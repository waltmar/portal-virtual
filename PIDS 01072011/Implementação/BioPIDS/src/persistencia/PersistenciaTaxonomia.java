package persistencia;

import itensParaPersistencia.Taxonomia;

import java.sql.SQLException;

public class PersistenciaTaxonomia extends Persistencia {
	
public Taxonomia buscarPorPai (Taxonomia t) throws SQLException {
	 	
	 	iniciarConexao();
	 	
	 	query = "SELECT * FROM "+ t.NomeTabela() +" WHERE pai = ? ";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(t.Id()) );
	 	res = stmt.executeQuery();
	 	Taxonomia t1 = new Taxonomia();  
	 	while( res.next() ) {
	 	
		t1.setId( Integer.toString(res.getInt("id_item")) );
		t1.setNome( res.getString( "nome" ) );  
		t1.setPai( Integer.toString(res.getInt("pai") ) );  
	 	}
		encerrarConexao();

	 	return t1;
	 }

}

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.scbio.domain.EntityGeneric;
import br.com.scbio.domain.EntityPersist;
import br.com.scbio.domain.Reino;
import br.com.scbio.persistence.CreateQuery;
import br.com.scbio.persistence.GenericPersistence;






class Livro extends EntityPersist{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String autor;
	private  float preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public  float getPreco() {
		return preco;
	}
	public void setPreco( float preco) {
		this.preco = preco;
	}
	
	
}

class Usuario extends EntityPersist{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String fone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
}




class Principal {



public static void main(String args[]) throws IllegalArgumentException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, SQLException, InstantiationException, NoSuchMethodException, SecurityException  {  

		Reino l = new Reino();
		l.setNome("Algo");
		CreateQuery<EntityPersist> q = new CreateQuery<EntityPersist>();
		String valor = q.CreateQuerySave(l);
			
		//System.out.println(valor); 
		//GenericPersistence<EntityPersist> gp= new GenericPersistence<EntityPersist>();
		//gp.save(l);
		//l.setId_item(2);
		//l = (Reino) gp.getById(l);
		ArrayList<String> list = new ArrayList<String>();
		list = q.getSets(l);
		//for (int i = 0; i < list.size(); i++) {
		//	System.out.println(list.get(i));
		//}
		
		System.out.println(q.CreateQueryGetById(l));
		System.out.println(l.getNome());
		GenericPersistence<EntityPersist> p = new GenericPersistence<EntityPersist>();
		l.setId_item(1);
		l = (Reino) p.getById(l);
		System.out.println(l.getNome());
		
	}
    
}  


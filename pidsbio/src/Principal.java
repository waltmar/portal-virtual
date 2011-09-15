import java.lang.reflect.Field;
import java.lang.reflect.Method;



class GenericBean{
	
	private String id_item;

	public String getId_item() {
		return id_item;
	}
	public void setId_item(String id_item) {
		this.id_item = id_item;
	}
	
}


class Livro extends GenericBean{
	
	
	private String nome;
	private String autor;
	private String preco;
	
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
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	
}

class Usuario extends GenericBean{
	
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

class MinhaQuery<T extends GenericBean> {
	
	/*
	 Esta classe utiliza o conceito de reflexão
	 Ela recebe um objeto qualquer e consegue "Enxergar" seu conteúdo
	 No caso dessa classe:
	 	-encontra o nome da classe ao qual o objeto foi instanciado.
		-encontra todos os métodos que dessa classe.
		-Chama apenas métodos get de interesse.
	 
	 */
	
	public String CriarQueryCadastro(T entity){
		
		String query = "INSERT INTO ";
		query = query + entity.getClass().getSimpleName();//insere o nome da tabela 
		
		try {  
			
			Class<?> cls = Class.forName(entity.getClass().getSimpleName());	
			
			Method listaMetodos[] = cls.getMethods(); //busca todos os métodos da classe
			
			query = query + " (";
			
			for (int i = 0; i < (listaMetodos.length - 1) ; i++) {
				
				
				Method m = (listaMetodos[i]);  
				if (m.getName().contains("get") ) { 
				String aux = (String) m.getName();
				aux = aux.substring(3);
				aux = aux.toLowerCase();
				query = query + aux;// armazena o primeiro atributo da classe
				query = query +", ";
				}
				
			}
			
			query = query.substring(0, query.length()-2);//retira a ultima vírgula 
			query = query + ")";
			
			query = query + " VALUES (";
			
			
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
	
	public String CriarQueryExclusao (T entity){
		
		String query = "DELETE FROM ";
		query = query + entity.getClass().getSimpleName();//insere o nome da tabela 
		query = query + " WHERE ";
		try {  
			
			Class<?> cls = Class.forName(entity.getClass().getSimpleName());	
			Method listaMetodos[] = cls.getMethods(); //busca todos os métodos da classe
			
			for (int i = 0; i < listaMetodos.length; i++) {
				 
				Method m = (listaMetodos[i]);  
				if (m.getName().equals("getId_item") ) {
					String id = (String) m.invoke(entity, new Object[0]);
					query = query + "id_item = "+id;
				}
			}
			
			}catch (Exception e) {}
		
		return query; 
			
	}
		
		
}

class Principal {

public static void main(String args[])  {  

		Livro l = new Livro();
		l.setNome("A arte da Guerra");
		l.setPreco("1.99");
		l.setAutor("Sun Tsu");
		l.setId_item("007");
		MinhaQuery<GenericBean> q = new MinhaQuery<GenericBean>();
		String valor = q.CriarQueryCadastro(l);
			
		System.out.println(valor); 
		
		Usuario u = new Usuario();
		u.setNome("João");
		u.setFone("114466");
		u.setId_item("02");
		
		valor = q.CriarQueryCadastro(u);
		
		System.out.println(valor);
		
		
		valor = q.CriarQueryExclusao(l);
		
		System.out.println(valor);
	   
	
	}
    
}  


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class EntityPersist implements Serializable{

	private static final long serialVersionUID = 1L;

	private float id_item;

	public float getId_item() {
		return id_item;
	}

	public void setId_item(float id_item) {
		this.id_item = id_item;
	}
	
	
}



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

class MinhaQuery<T extends EntityPersist> {
	
	/*
	 Esta classe utiliza o conceito de reflexão
	 Ela recebe um objeto qualquer e consegue "Enxergar" seu conteúdo
	 No caso dessa classe:
	 	-encontra o nome da classe ao qual o objeto foi instanciado.
		-encontra todos os métodos que dessa classe.
		-Chama apenas métodos get de interesse.
	 
	 */
	public MinhaQuery(){}

	private String getNameClass(T entity) {
		// TODO Auto-generated method stub
		return entity.getClass().getSimpleName();
	}
	
	private Class<?> getClass(T entity) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class<?> cls = Class.forName(entity.getClass().getSimpleName());
		return cls;
	}
	
	private String getQueryFields(T entity) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class<?> cls = getClass(entity);
		Method listaMetodos[] = cls.getMethods();
		String subquery1= " (";
		String subquery2= subquery1;
		
		for (int i = 0; i < listaMetodos.length  ; i++) {
			
			
			Method m = (listaMetodos[i]);  
			if (m.getName().contains("get") ) {
				
				String aux;
				aux = (String) m.getName();
				aux = aux.substring(3);
				
				
				subquery1 = subquery1 + aux;
				subquery1 = subquery1 +", ";
				
				if (!m.getName().contains("getClass")){
					if (m.getReturnType().getSimpleName().equals("String")){
						
						subquery2 = subquery2 + "'"+ m.invoke(entity, new Object[0])+"'";
						subquery2 = subquery2 +", ";
					} else{
						subquery2 = subquery2 +  m.invoke(entity, new Object[0]) ;// armazena o primeiro atributo da classe
						subquery2 = subquery2 +", ";
					}
				}
			}
			
		}
		
		subquery1 = subquery1.toLowerCase();
		subquery2 = subquery2.toLowerCase();
		
		subquery1 = subquery1.substring(0, subquery1.length()-9);//retira a ultima vírgula e o atributo class 
		subquery1 = subquery1 + ")";
		subquery2 = subquery2.substring(0, subquery2.length()-2);
		subquery2 = subquery2 + ")";
		
		 
		
		return subquery1 +  " VALUES" + subquery2;
	}
	
	public String CreateQuerySave(T entity) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		String query = "INSERT INTO ";
		query = query + getNameClass(entity); 
		query = query + getQueryFields(entity);
			
		return query; 
	
	
	}
	
	public String CriarQueryExclusao (T entity){
		
		String query = "DELETE FROM ";
		query = query + getNameClass(entity); //insere o nome da tabela 
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

public static void main(String args[]) throws IllegalArgumentException, ClassNotFoundException, IllegalAccessException, InvocationTargetException  {  

		Livro l = new Livro();
		l.setNome("A arte da Guerra");
		l.setPreco((float) 1.99);
		l.setAutor("Sun Tsu");
		l.setId_item((float) 007);
		MinhaQuery<EntityPersist> q = new MinhaQuery<EntityPersist>();
		String valor = q.CreateQuerySave(l);
			
		System.out.println(valor); 
		
		Usuario u = new Usuario();
		u.setNome("João");
		u.setFone("114466");
		u.setId_item((float) 02);
		 
		valor = q.CreateQuerySave(u);
		
		System.out.println(valor);
		
		
		valor = q.CriarQueryExclusao(l);
		
		System.out.println(valor);
	   
	
	}
    
}  


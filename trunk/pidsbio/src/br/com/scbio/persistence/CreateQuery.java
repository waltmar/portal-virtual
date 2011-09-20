package br.com.scbio.persistence;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.scbio.domain.EntityPersist;

public class CreateQuery<T extends EntityPersist> {
	
	/*
	 Esta classe utiliza o conceito de reflexão
	 Ela recebe um objeto qualquer e consegue "Enxergar" seu conteúdo
	 No caso dessa classe:
	 	-encontra o nome da classe ao qual o objeto foi instanciado.
		-encontra todos os métodos que dessa classe.
		-Chama apenas métodos get de interesse.
	 
	 */
	public CreateQuery(){}
	
	public String CreateQuerySave(T entity) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		String query =  getQueryFields(entity);
		query  = query.replaceAll(", id_item", "");
		query  = query.replaceAll(", 0.0", "");
		
		return "INSERT INTO " + getNameClass(entity)+ query;
	
	}
	
	public String CreateQuerUpdate(T entity) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		return "INSERT INTO " + getNameClass(entity) + getQueryFields(entity);
	
	}

	public String CriateQueryDelete (T entity) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		return "DELETE FROM " + getNameClass(entity) + " WHERE " + queryById(entity);
	
	}
	
	public String CriateQueryGetAll(T entity) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		return "SELECT * FROM " + getNameClass(entity);
		
	}
	
	public String CriateQueryGetById(T entity) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		return CriateQueryGetAll(entity) + " WHERE " + queryById(entity);
		
	}	
	
		
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
				
				if (!m.getName().contains("getClass")){
					if (m.getReturnType().getSimpleName().equals("String")){
						
						subquery2 = subquery2 + "'"+ m.invoke(entity, new Object[0])+"'";
						subquery2 = subquery2 +", ";
					} else{
						subquery2 = subquery2 +  m.invoke(entity, new Object[0]) ;// armazena o primeiro atributo da classe
						subquery2 = subquery2 +", ";
					}
				}
							
				subquery1 = subquery1 + m.getName().substring(3);
				subquery1 = subquery1 +", ";
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
	
	
	public String queryById(T entity) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> cls = getClass(entity);	
		Method listaMetodos[] = cls.getMethods(); //busca todos os métodos da classe
		
		for (int i = 0; i < listaMetodos.length; i++) {
			 
			Method m = (listaMetodos[i]);  
			if (m.getName().equals("getId_item") ) {
				float id = (Float) m.invoke(entity, new Object[0]);
				return "id_item = "+ id;
			}
		}
		return null;
	}
	
	
	
	
	
		
}



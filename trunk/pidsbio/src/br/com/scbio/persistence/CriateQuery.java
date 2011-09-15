package br.com.scbio.persistence;

import java.lang.reflect.Method;

public class CriateQuery<T> {
	
		/*
		 Esta classe utiliza o conceito de reflexão
		 Ela recebe um objeto qualquer e consegue "Enxergar" seu conteúdo
		 No caso dessa classe:
		 	-encontra o nome da classe ao qual o objeto foi instanciado.
			-encontra todos os métodos que dessa classe.
			-Chama apenas métodos get de interesse.
		 
		 */
		
		public String CriateQuerySave(T entity){
			
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
		
		public String CriateQueryDelete(T entity){
			
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

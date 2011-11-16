package br.com.biopids.persistence;

import java.io.Serializable;

public class Criteria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6032332200685541642L;
	private String nameCollun;
	private String typeCriteria;
	private Object[] values;
	private Criteria next;
	
	public static final String LIKE = "like '%%campo0%'";
	public static final String EQUAL = "= '%campo0'";
	public static final String BETWEEN = "between '%campo0' and '%campo1'";
	
	
	public Criteria(String typeCriteria, String nameCollun, Object ... values){
		this.nameCollun = nameCollun;
		this.typeCriteria = typeCriteria;
		this.values = values;
	}
	
	public Criteria(String nameCollun, Object ... values){
		this.nameCollun = nameCollun;
		this.values = values;
	}
	
	public String getSql(){
		String aux = montarSql();
		aux = popularCampos(aux);
		if(this.next != null){
			aux = aux + " and " + this.next.getSql();
		}
		return aux;
	}
	
	public void concatCriteria(Criteria criteria){
		if(this.next == null){
			this.next = criteria;
		}else{
			this.next.concatCriteria(criteria);
		}
	}
	
	private String montarSql(){
		if(typeCriteria == null){
		   selectTypeCriteria();
		}
			return this.nameCollun + " " + this.typeCriteria;
	}
	
	private void selectTypeCriteria() {
		Object value = values[0];
		if (value instanceof String) {
			typeCriteria = LIKE;
		}else{
			typeCriteria = EQUAL;
		}
	}

	private String popularCampos(String sql){
		Integer i = 0;
		for (Object value : values) {
			if(value.getClass().isEnum()){
				System.out.println(value.getClass().getCanonicalName());
			}
			sql = sql.replaceAll("%campo"+i.toString(),value.toString());
			i++;
		}
		return sql;
	}
	
	

}

package br.com.biopids.persistence;

public class GenericSearch {
	
	private String[] colluns;
	private Criteria criteria;
	private StringBuilder tables;
	private String tableFather;
	private static final String SELECT = "SELECT";
	private static final String FROM = "FROM";
	private static final String WHERE = "WHERE";
	
	public GenericSearch(Criteria criteria,String tableFather, String ... colluns){
		this.criteria = criteria;
		this.colluns = colluns;
		this.tables = new StringBuilder();
		tables.append(FROM);
		this.tableFather = tableFather;
	}
	
	public String getSqlSearch(){
		StringBuilder sb = new StringBuilder();
		sb.append(getSelect());
		sb.append(" ");
		sb.append(getSqlFrom());
		sb.append(" ");
		sb.append(getWhere());
		return  sb.toString();
	}
	
	private String getSelect(){
		StringBuilder sb = new StringBuilder();
		sb.append(SELECT);
		for(int i = 0; i < colluns.length; i++){
			sb.append(" " + colluns[i] + ",");
			sqlFrom(colluns[i]);
		}
		String aux = sb.toString();
		return aux.substring(0, aux.length() - 1);
	}
	
	private void sqlFrom(String collum){
		int pos = collum.indexOf(".");
		String table = collum.substring(0, pos);
		String aux = tables.toString();
		if(!aux.contains(table)){
			tables.append(this.tableFather);
			tables.append(".");
			tables.append(table);
			tables.append(" as ");
			tables.append(table);
			tables.append(", ");
		}
	}
	
	private String getSqlFrom(){
		String aux = tables.toString();
		return aux.substring(0, aux.length() - 2);
	}
	
	private String getWhere(){
		String aux = "";
		if(criteria != null)
			aux =this.criteria.getSql();
		return aux;
	}

}

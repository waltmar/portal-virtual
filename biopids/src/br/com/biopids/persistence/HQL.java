package br.com.biopids.persistence;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.com.biopids.converter.ContainerMappingClass;
import br.com.biopids.converter.MappingClass;
import br.com.biopids.converter.MappingField;

public class HQL<T> {
	private Class<?> classSearch;
	private List<String> fields;
	private List<String> conditions;
	private Criteria criteria;
	private List<String> tables;
	private List<String> orders;
	private Map<String, Object> mappingObjects;
	private Map<String, MappingClass> mappingClass;
	private Object objectFather;

	public HQL(Class<?> classSearch) {
		this.classSearch = classSearch;
		this.fields = new ArrayList<String>();
		this.conditions = new ArrayList<String>();
		this.orders = new ArrayList<String>();
		this.tables = new ArrayList<String>();
		this.mappingObjects = new HashMap<String, Object>();
		this.mappingClass = new HashMap<String, MappingClass>();
	}

	public HQL<T> fields(String... colluns) {
		for (String collun : colluns) {
			this.fields.add(collun);
		}
		return this;
	}

	public HQL<T> conditions(String... conditions) {
		for (String condition : conditions) {
			this.conditions.add(condition);
		}
		return this;
	}

	public HQL<T> froms(String... tables) {
		for (String table : tables) {
			this.tables.add(table);
			mappingObject(table);
		}
		return this;
	}
	
	private void renewObject(){
		try{
		renewObjectFather();
		for(String table : this.tables){
			if(table.contains("."))
			renew(table);			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void renewObjectFather() throws Exception {
		String[] nameTableFather = getNameAndAlias(this.tables.get(0));
		MappingClass mapping = this.mappingClass.get(nameTableFather[1]);
		this.mappingObjects.remove(nameTableFather[1]);
		this.objectFather = classSearch.newInstance();
		this.mappingObjects.put(nameTableFather[1], this.objectFather);
	}

	private void renew(String table)throws Exception {
		String[] namesInternal = getNameAndAlias(table);
		String[] namesTable = getNameFatherAndNameObject(namesInternal[0]);
		MappingClass mappingClass = this.mappingClass.get(namesTable[0]);
		MappingField mappingField = mappingClass.getMappingFieldByNameField(namesTable[1]);
		Object objectFather = this.mappingObjects.get(namesTable[0]);
		Object objectSon = mappingField.getClassType().newInstance();
		mappingField.setValue(objectFather, objectSon );
		this.mappingObjects.remove(namesInternal[1]);
		this.mappingObjects.put(namesInternal[1], objectSon);
	}

	private void mappingObject(String table) {
		try{
		if (table.contains(".")) {
			mappingObjectInternal(table);
		} else {
			mappingObjectFather(table);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mappingObjectFather(String table)
			throws InstantiationException, IllegalAccessException {
		String[] names = getNameAndAlias(table);
		this.mappingClass.put(names[1], ContainerMappingClass.getInstance()
				.getMappingClass(classSearch));

	}

	private void mappingObjectInternal(String table)
			throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, InstantiationException {
		String[] namesObjectInternal = getNameAndAlias(table);
		String[] nameFatherAndAtritute = getNameFatherAndNameObject(namesObjectInternal[0]);
		MappingClass mappingClassFather = this.mappingClass.get(nameFatherAndAtritute[0]);
		MappingField mappingField = mappingClassFather.getMappingFieldByNameField(nameFatherAndAtritute[1]);
		this.mappingClass.put(namesObjectInternal[1], ContainerMappingClass.getInstance().getMappingClass(mappingField.getClassType()));

	}

	private String[] getNameFatherAndNameObject(String table) {
		int pos = table.indexOf(".");
		return new String[] { table.substring(0, pos), table.substring(pos + 1) };
	}

	private String[] getNameAndAlias(String table) {
		int pos = table.indexOf(" as ");
		return new String[] { table.substring(0, pos),
				table.substring(pos + 4, table.length()) };
	}

	public HQL<T> orders(String... orders) {
		if (orders != null) 
		for (String order : orders) {
			this.orders.add(order);
		}
		return this;
	}

	private String fields() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		for (String field : this.fields) {
			sb.append(field);
			sb.append(", ");
		}
		return sb.substring(0, sb.length() - 2);

	}

	private String tables() {
		String aux = "";
		if (!this.tables.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" FROM ");
			for (String table : this.tables) {
				sb.append(table);
				sb.append(" left join ");
			}
			aux = sb.substring(0, sb.length() - 11);
		}
		return aux;
	}
	
	private String getSqlCondition(){
		String aux;
		if (criteria == null){
			aux = condition();
		}else{
			aux = " WHERE " + this.criteria.getSql();
		}
		return aux;
	}

	private String condition() {
		String aux = "";
		if (!this.conditions.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" WHERE ");
			for (String condition : this.conditions) {
				sb.append(condition);
				sb.append(" and ");
			}
			aux = sb.substring(0, sb.length() - 5);

		}
		return aux;

	}

	private String order() {
		String aux = "";
		if (!this.orders.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" ORDER BY ");
			for (String order : this.orders) {
				sb.append(order);
				sb.append(", ");
			}
			aux = sb.substring(0, sb.length() - 2);
		}
		return aux;
	}

	public String build() {
		checkColluns();
		StringBuilder sb = new StringBuilder();
		sb.append(fields());
		sb.append(tables());
		sb.append(getSqlCondition());
		sb.append(order());
		return sb.toString();
	}

	private void checkColluns() {
		List<String> newFields = new ArrayList<String>();
		for(String field : this.fields){
			newFields.add(mappingField(field));
		}
		this.fields = newFields;
		
	}

	private String mappingField(String field) {
		String aux = field.replaceFirst(".", "");
		if(aux.contains(".")){
			field = mappingMultipleField(field);
		}
		return field;
		
		
	}

	private String mappingMultipleField(String field) {
		String endField = field;
		int pos = field.indexOf('.'); 
		while(pos != -1){
			String classFather = field.substring(0, pos);
			String restField = field.substring(pos + 1, field.length());
			int pos2 = restField.indexOf('.');
			if(pos2 != -1){
				String classSon = restField.substring(0, pos2);
				checkClassSon(classFather, classSon);
				field = field.substring(pos + 1, field.length());
				endField = field;
				pos = field.indexOf('.');
			}else{
				pos = -1;
			}
		}
		return endField;
	}

	private void checkClassSon(String classFather, String classSon) {
		if(!mappingClass.containsKey(classSon)){
			mappingClassSon(classFather, classSon);
		}
		
	}

	private void mappingClassSon(String classFather, String classSon) {
		MappingClass mappingClassFather = mappingClass.get(classFather);
		MappingField mappingField = mappingClassFather.getMappingFieldByNameField(classSon);
		Class<?> classeSon = mappingField.getClassType();
		this.mappingClass.put(classSon, ContainerMappingClass.getInstance().getMappingClass(classeSon));
		StringBuilder sb = new StringBuilder();
		sb.append(mappingClassFather);
		sb.append(".");
		sb.append(classSon);
		sb.append(" as ");
		sb.append(classSon);
		this.tables.add(sb.toString());
	}

	public List<T> load(List<Object[]> records) throws Exception {
		List<T> list = new ArrayList<T>();
		if (records != null) {
		for (Object[] object : records) {
			renewObject();
			list.add(load(object));
		} 
		} 
		return list;
	}

	private T load(Object[] objects) throws Exception {
		for (int i = 0; i < this.fields.size(); i++) {
			setValue(objects[i], this.fields.get(i));

		}
		return (T) this.objectFather;
	}

	private void setValue(Object record, String campo)
			throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, InstantiationException {
		if (record != null) {
			String names[] = getNameFatherAndNameObject(campo);
			MappingClass mappingClass = this.mappingClass.get(names[0]);
			Object objectSet = this.mappingObjects.get(names[0]);
			MappingField mappingField = mappingClass.getMappingFieldByNameField(names[1]);
			mappingField.setValue(objectSet, record);
		}

	}
	
	public void setCriteria(Criteria criteria){
		this.criteria = criteria;
	}
	
	public Criteria getCriteria(){
		return this.criteria;
	}
	
	public List<String> getTables(){
		return this.tables;
	}
}

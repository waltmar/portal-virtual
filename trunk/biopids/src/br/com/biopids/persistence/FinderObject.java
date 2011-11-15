package br.com.biopids.persistence;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import br.com.biopids.converter.ContainerMappingClass;
import br.com.biopids.converter.MappingClass;
import br.com.biopids.converter.MappingField;
import br.com.biopids.interfaces.IDAO;
import br.com.biopids.util.EmptyValue;

public class FinderObject<T> {
	
	private Object objectFinder;
	private HQL<T> hql;
	private MappingClass mappingClass;
	private String aliasTableFather;
	private List<Criteria> criterias;
	
	public FinderObject(Object objectFinder){
		this.objectFinder = objectFinder;
		this.hql = new HQL<T>(objectFinder.getClass());
		this.mappingClass = ContainerMappingClass.getInstance().getMappingClass(objectFinder.getClass());
		criterias = new ArrayList<Criteria>();
	}
	
	public List<T> getByFinder(IDAO idao,String[] orders, String ...colluns) throws Exception{
		setInformationsHql(orders, colluns);
		prepareCriteria();
		return executeQuery(idao);
	}
	
	public List<T> getByFinder(IDAO idao, String ...colluns) throws Exception{
		setInformationsHql(colluns);
		prepareCriteria();
		return executeQuery(idao);
	}
	
	private void setInformationsHql(String ...colluns) throws Exception{
		hql.fields(colluns);
		mappingClassFather();
		mappingObject(mappingClass.getListMappingField());
	}
	
	private void setInformationsHql(String[] orders, String ...colluns) throws Exception{
		setInformationsHql(colluns);
		hql.orders(orders);
	}
		

	private void prepareCriteria() {
		if(!criterias.isEmpty()){
			Criteria criteria = criterias.get(0);
			for(int i = 1; i<criterias.size(); i++){
				criteria.concatCriteria(criterias.get(i));
			}
			hql.setCriteria(criteria);
		}	
	}

	private void mappingClassFather() {
		String nameClassFather = objectFinder.getClass().getSimpleName();
		hql.froms(nameClassFather + " as " + nameClassFather.toLowerCase());
		aliasTableFather = nameClassFather.toLowerCase();
	}

	private List<T> executeQuery(IDAO idao) throws Exception {
		String sql = hql.build();
		return hql.load(idao.executeQuery(sql));
	}

	private void mappingObject(	Collection<MappingField> fields) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		for (MappingField mappingField : fields) {
			checkMappingField(mappingField);
		}
		
	}

	private void checkMappingField(MappingField mappingField) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(!mappingField.getClassType().isAssignableFrom(List.class)){
			mappingField(mappingField);
		}
	}
	
	private void mappingField(MappingField mappingField) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object value = mappingField.getValue(objectFinder);
		
			OneToOne oneToOne =(OneToOne) mappingField.getAnnotation(OneToOne.class);
			ManyToOne manyToOne = (ManyToOne) mappingField.getAnnotation(ManyToOne.class);
			if((oneToOne == null)&&(manyToOne == null)){
				if(!EmptyValue.isEmpty(value)){
					finderField(mappingField, value);
				}
			}else{
				mappingInternalClassDomain(mappingField);
			}
		
	}

	private void mappingInternalClassDomain(MappingField mappingField) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		MappingClass mappingClass = ContainerMappingClass.getInstance().getMappingClass(mappingField.getClassType());
		String nameTableSon = mappingField.getNameField();
		hql.froms(aliasTableFather +"." + nameTableSon + " as " + nameTableSon);
		String auxTableFather = this.aliasTableFather;
		this.aliasTableFather = nameTableSon;
		Object newObjectSearc = mappingField.getValue(this.objectFinder);
		Object aux = this.objectFinder;
		this.objectFinder = newObjectSearc;
		mappingObject(mappingClass.getListMappingField());
		this.objectFinder = aux;
		this.aliasTableFather = auxTableFather;
	}

	private void finderField(MappingField mappingField, Object value) {
		if(mappingField.getFielAncestor() == null){
			Criteria criteria = new Criteria(aliasTableFather + "." + mappingField.getNameField(), value);
			criterias.add(criteria);
		}else{
			finderFieldAncestor(mappingField, value);
		}
		
	}

	private void finderFieldAncestor(MappingField mappingField, Object value) {
		String aliasAncestor = mappingField.getFielAncestor().getNameField();
		Criteria criteria = new Criteria(Criteria.EQUAL, aliasAncestor.toLowerCase() + "." + mappingField.getNameField(), value);
		criterias.add(criteria);
		while(mappingField.getFielAncestor() != null){
			mappingField = mappingField.getFielAncestor();
			String nameField = mappingField.getNameField();
			nameField = nameField + " as " + nameField.toLowerCase();
			if(!hql.getTables().contains(nameField)){
				hql.froms(nameField);
			}
		}
		
	}
	
	

}

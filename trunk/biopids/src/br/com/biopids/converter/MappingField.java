package br.com.biopids.converter;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MappingField implements Serializable{
	
	private boolean containsAnnotations;
	private Map<Class<?>, Annotation> annotations;
	private MappingField fielAncestor;
	private Class<?> classType;
	private Class<?> classFather;
	private Method methodGet;
	private Method methodSet;
	private String nameField;
	
	

	public MappingField(Field field, boolean containsAnnotaions, Class<?> classFather){
		this.containsAnnotations = containsAnnotaions;
		this.classFather = classFather;
		try{
			mapping(field);
		}catch (Exception e) {}
	}
	
	public MappingField(Method methodGet, Method methodSet, boolean containsAnnotations, Class<?> classType) {
		this.classType = classType;
		this.methodGet = methodGet;
		this.methodSet = methodSet;
		this.containsAnnotations = containsAnnotations;
	}
	
	public Annotation getAnnotation(Class<?> annotationClass){
		Annotation annotation = null;
		if (annotations.containsKey(annotationClass)){
			annotation = annotations.get(annotationClass);
		}
		return annotation;
	}
	
	public Object getValue(Object object) throws IllegalArgumentException, IllegalAccessException, SecurityException, InvocationTargetException, NoSuchMethodException{
		if(this.fielAncestor != null){
			object = this.fielAncestor.getValue(object);
		}
		if(object != null)
			object = getValueObject(object);
		return object;
	}
	
	private Object createInstance() throws InstantiationException, IllegalAccessException {
		return classType.newInstance();
	}

	private Object getValueObject(Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		Object value = this.methodGet.invoke(object, null);
		return value;
	}
	
	public void setValue(Object object, Object value) throws IllegalArgumentException, IllegalAccessException, SecurityException, InvocationTargetException, NoSuchMethodException, InstantiationException{
		if(this.fielAncestor != null){
			object = this.fielAncestor.getValueForSetValue(object);
		}
		setValueObject(object, value);
		
	}
	
	public Object getValueForSetValue(Object object) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SecurityException, InvocationTargetException, NoSuchMethodException{
		Object object2 = null;
		if(this.fielAncestor != null){
			object = this.fielAncestor.getValueForSetValue(object);
		}
		if(object != null){
			object2 = object;
			object = getValueObject(object);
		}
		if(object == null){
			object = createInstance();
			setValueObject(object2, object);
		}
		return object;
	}
	
	private void setValueObject(Object object, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		this.methodSet.invoke(object, value);
	}
	
	private void mapping(Field field) throws SecurityException, NoSuchMethodException{
		this.nameField = field.getName();
		this.classType = field.getType();
		annotations = new HashMap<Class<?>, Annotation>();
		Annotation list[] = field.getAnnotations();
		for (Annotation annotation : list) {
			annotations.put(annotation.annotationType(), annotation);
		}
		mappingMethods();
	}

	public MappingField getFielAncestor() {
		return fielAncestor;
	}

	public void setFielAncestor(MappingField fielAncestor) {
		this.fielAncestor = fielAncestor;
	}
	
	public MappingField clone(){
		MappingField mappingField = new MappingField(this.methodGet, this.methodSet, this.containsAnnotations, this.classType);
		mappingField.setAnnotations(this.annotations);
		mappingField.setClassFather(this.classFather);
		mappingField.setFielAncestor(this.fielAncestor);
		mappingField.setNameField(this.nameField);
		return mappingField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annotations == null) ? 0 : annotations.hashCode());
		result = prime * result + (containsAnnotations ? 1231 : 1237);
		result = prime * result
				+ ((fielAncestor == null) ? 0 : fielAncestor.hashCode());
		result = prime * result
				+ ((methodGet == null) ? 0 : methodGet.hashCode());
		result = prime * result
				+ ((methodSet == null) ? 0 : methodSet.hashCode());
		result = prime * result
				+ ((nameField == null) ? 0 : nameField.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MappingField other = (MappingField) obj;
		if (annotations == null) {
			if (other.annotations != null)
				return false;
		} else if (!annotations.equals(other.annotations))
			return false;
		if (containsAnnotations != other.containsAnnotations)
			return false;
		if (fielAncestor == null) {
			if (other.fielAncestor != null)
				return false;
		} else if (!fielAncestor.equals(other.fielAncestor))
			return false;
		if (methodGet == null) {
			if (other.methodGet != null)
				return false;
		} else if (!methodGet.equals(other.methodGet))
			return false;
		if (methodSet == null) {
			if (other.methodSet != null)
				return false;
		} else if (!methodSet.equals(other.methodSet))
			return false;
		if (nameField == null) {
			if (other.nameField != null)
				return false;
		} else if (!nameField.equals(other.nameField))
			return false;
		return true;
	}

	public Map<Class<?>, Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Map<Class<?>, Annotation> annotations) {
		this.annotations = annotations;
	}
	
	private void mappingMethods() throws SecurityException, NoSuchMethodException{
		mappingMethodGet();
		mappingMethodSet();
	}
	
	private void mappingMethodGet() throws SecurityException, NoSuchMethodException{
		String aux = upFirstLetter();
		String methodGet = "get" + aux;
		this.methodGet = this.classFather.getMethod(methodGet);
	}
	
	private void mappingMethodSet() throws SecurityException, NoSuchMethodException{
		String aux = upFirstLetter();
		String methodSet = "set" + aux;
		this.methodSet = this.classFather.getMethod(methodSet, this.classType);
	}
	
	private String upFirstLetter(){
		String firstLetter = nameField.substring(0,1);
		firstLetter = firstLetter.toUpperCase();
		return firstLetter + nameField.substring(1,nameField.length());
	}

	public Class<?> getClassType() {
		return classType;
	}

	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}

	public Class<?> getClassFather() {
		return classFather;
	}

	public void setClassFather(Class<?> classFather) {
		this.classFather = classFather;
	}

	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
	}
	
	
	
}

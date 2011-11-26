package br.com.biopids.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import br.com.biopids.annotation.FieldBean;
import br.com.biopids.annotation.InnerClassDomain;


public class MappingModelToDomain implements Serializable{

	private ContainerMappingClass mappingClass = ContainerMappingClass
			.getInstance();
	private Class<?> classModel;
	private Class<?> classDomain;
	private MappingClass mappingClassModel;
	private MappingClass mappingClassDomain;
	private Collection<MappingFieldToField> mappingFieldToField;
	private MappingField fieldAncestor;

	public MappingModelToDomain(Class<?> classModel, Class<?> classDomain) {
		setClassDomain(classDomain);
		setClassModel(classModel);
		this.mappingFieldToField = new ArrayList<MappingFieldToField>();
		this.fieldAncestor = null;
	}

	public MappingModelToDomain(Class<?> classModel, Class<?> classDomain,
			MappingField fieldAncestor) {
		setClassDomain(classDomain);
		setClassModel(classModel);
		this.mappingFieldToField = new ArrayList<MappingFieldToField>();
		this.fieldAncestor = fieldAncestor;

	}

	public Collection<MappingFieldToField> mapping()
			throws IllegalArgumentException, IllegalAccessException, Exception {
		Collection<MappingField> fields = mappingClassModel.getListMappingField();
		for (MappingField mapping : fields) {
			selectedTypeConvert(mapping);
		}
		return this.mappingFieldToField;
	}

	private void selectedTypeConvert(MappingField mapping)
			throws IllegalArgumentException, IllegalAccessException, Exception {
		InnerClassDomain innerClassDomain = (InnerClassDomain) mapping.getAnnotation(InnerClassDomain.class);
		if (innerClassDomain == null) {
			setValueInField(mapping);
		} else {
			setValue(innerClassDomain, mapping);
		}
	}

	private void setValueInField(MappingField mapping) throws Exception {
		FieldBean fieldBean = (FieldBean) mapping
				.getAnnotation(FieldBean.class);
		if (fieldBean == null) {
			setValue(mapping, mapping.getNameField());
		} else {
			setValue(fieldBean, mapping);
		}
	}

	private void setValue(FieldBean fieldBean, MappingField mapping)
			throws Exception {
		if (fieldBean.internalClass()) {
			setValueInternalClassModel(mapping);
		} else {
			setValue(mapping, getNameAtribute(mapping));
		}
	}

	private void setValueInternalClassModel(MappingField mapping)
			throws Exception {
		MappingModelToDomain mappingAux = new MappingModelToDomain(mapping.getClassType(), classDomain, mapping);
		Collection<MappingFieldToField> list = mappingAux.mapping();
		this.mappingFieldToField.addAll(list);
	}

	private String getNameAtribute(MappingField mapping) {
		String nomeField = "";
		FieldBean annotation = (FieldBean) mapping
				.getAnnotation(FieldBean.class);
		if (annotation == null || annotation.name().equalsIgnoreCase("")) {
			nomeField = mapping.getNameField();
		} else {
			nomeField = annotation.name();
		}
		return nomeField;
	}

	private void setValue(MappingField mapping, String nameField)
			throws Exception {
		MappingField mappingFieldDomain = this.mappingClassDomain.getMappingFieldByNameField(nameField);
		if (mappingFieldDomain != null) {
			mapping.setFielAncestor(this.fieldAncestor);
			MappingFieldToField mappingFieldToField = new MappingFieldToField(mapping, mappingFieldDomain);
			this.mappingFieldToField.add(mappingFieldToField);
		}
	}

	private MappingField getInnerClassDomain(String[] local)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		MappingField mappingField = this.mappingClassDomain.getMappingFieldByNameField(local[0]);
		MappingField mappingFieldAncestor = mappingField;
		for (int i = 1; i < local.length; i++) {
			mappingField = getField(mappingField.getClassType(), local[i]);
			mappingField.setFielAncestor(mappingFieldAncestor);
			mappingFieldAncestor = mappingField;
		}
		return mappingField;
	}

	private MappingField getField(Class<?> classe, String nameField) throws SecurityException, NoSuchFieldException {
		MappingClass mappingClass = ContainerMappingClass.getInstance().getMappingClass(classe);
		return mappingClass.getMappingFieldByNameField(nameField);
	}

	private void setValue(InnerClassDomain anotation,MappingField mappingFieldModel) throws Exception {
		MappingField mappingFieldDomain = getInnerClassDomain(anotation.local());
		mappingFieldModel.setFielAncestor(this.fieldAncestor);
		if(mappingFieldDomain != null){
			this.mappingFieldToField.add(new MappingFieldToField(mappingFieldModel,	mappingFieldDomain));
		}

	}

	private void mappingModel() {
		this.mappingClassModel = mappingClass.getMappingClass(this.classModel);
	}

	private void mappingDomain() {
		this.mappingClassDomain = mappingClass
				.getMappingClass(this.classDomain);
	}

	public Class<?> getClassModel() {
		return classModel;
	}

	public void setClassModel(Class<?> classModel) {
		this.classModel = classModel;
		mappingModel();
	}

	public Class<?> getClassDomain() {
		return classDomain;
	}

	public void setClassDomain(Class<?> classDomain) {
		this.classDomain = classDomain;
		mappingDomain();
	}

}

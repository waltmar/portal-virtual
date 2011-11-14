package br.com.biopids.interfaces;

import java.io.Serializable;

public interface IConverterEntity extends Serializable{

	Object convertEntity(Object classModel, Object classDomain) throws Exception;
	Object reconvertEntity(Object classModel, Object classDomain) throws Exception;
}

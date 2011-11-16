package br.com.biopids.interfaces;

import java.io.Serializable;

public interface IConverterField extends Serializable{
	
	public <T extends Object>T convertField(Class<T> classField, String value) throws Exception;
	
}

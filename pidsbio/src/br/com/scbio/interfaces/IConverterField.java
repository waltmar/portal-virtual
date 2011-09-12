package br.com.scbio.interfaces;

public interface IConverterField{
	
	public <T extends Object>T convertField(Class<T> classField, String value) throws Exception;
	
}

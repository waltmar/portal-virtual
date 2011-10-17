package br.com.scbio.util;

import java.io.Serializable;


public class FactoreProperties implements Serializable{
	
	private static PropertiesLoader properties;
		
	public static PropertiesLoader loadPtbr(){
		properties = new PropertiesLoader(br.com.scbio.language.Marcador.class, "pt_br.properties");
		return properties;
	}
	public static PropertiesLoader loadParameters(){
		properties = new PropertiesLoader(br.com.scbio.language.Marcador.class, "parameters.properties");	
		return properties;
	}
	
}

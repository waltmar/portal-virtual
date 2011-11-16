package br.com.biopids.util;

import java.io.Serializable;


public class FactoreProperties implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6402664077266821949L;

	public static PropertiesLoader loadPtbr(){
		PropertiesLoader properties = new PropertiesLoader(br.com.biopids.language.Marcador.class, "pt_br.properties");
		return properties;
	}
	public static PropertiesLoader loadParameters(){
		PropertiesLoader  properties = new PropertiesLoader(br.com.biopids.language.Marcador.class, "parameters.properties");	
		return properties;
	}
	
	public static PropertiesLoader loadIn8(){
		PropertiesLoader  properties = new PropertiesLoader(br.com.biopids.i8n.Marcador.class, "commons_messages.properties");	
		return properties;
	}
	
}

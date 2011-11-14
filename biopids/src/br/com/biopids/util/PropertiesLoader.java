package br.com.biopids.util;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.Serializable;
import java.util.Properties;  

import br.com.biopids.language.Marcador;
  
public class PropertiesLoader implements Serializable{  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Properties props;  
    private String nomeDoProperties = "pt_br.properties";
    private Class<?> classMarcador;
  
    public PropertiesLoader(Class<?> classMarcador){  
            props = new Properties();
            this.classMarcador = classMarcador;
            InputStream in = classMarcador.getResourceAsStream(nomeDoProperties);  
            try{  
                    props.load(in);  
                    in.close();  
            }  
            catch(IOException e){e.printStackTrace();}  
    }
    
    public PropertiesLoader(Class<?> classMarcador, String nameProperties){
    	 props = new Properties();
         this.classMarcador = classMarcador;
         InputStream in = classMarcador.getResourceAsStream(nameProperties);  
         try{  
                 props.load(in);  
                 in.close();  
         }  
         catch(IOException e){e.printStackTrace();}
    	
    }
    public String getEndereco(){
    	String e = this.classMarcador.getResource(nomeDoProperties).toString();
    	return e;
    }
  
    public String getValor(String chave){  
            return (String)props.getProperty(chave);  
    }  
} 
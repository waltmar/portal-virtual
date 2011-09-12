package br.com.scbio.util;
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Properties;  

import br.com.scbio.language.Marcador;


  
public class PropertiesLoader {  
  
    private Properties props;  
    private String nomeDoProperties = "pt_br.properties";  
  
    public PropertiesLoader(){  
            props = new Properties();  
            InputStream in = Marcador.class.getResourceAsStream(nomeDoProperties);  
            try{  
                    props.load(in);  
                    in.close();  
            }  
            catch(IOException e){e.printStackTrace();}  
    }
    public String getEndereco(){
    	String e = Marcador.class.getResource(nomeDoProperties).toString();
    	return e;
    }
  
    public String getValor(String chave){  
            return (String)props.getProperty(chave);  
    }  
} 
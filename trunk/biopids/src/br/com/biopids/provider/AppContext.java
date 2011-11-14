package br.com.biopids.provider;

import org.springframework.context.ApplicationContext;

public class AppContext { 
	 
    private static ApplicationContext ctx; 
 
    /**
     * Injected from the class "ApplicationContextProvider" which is automatically
     * loaded during Spring-Initialization.
     */ 
    public static void setApplicationContext(ApplicationContext applicationContext) { 
        ctx = applicationContext; 
    }
    
    public static ApplicationContext getApplicationContext(){
    	return ctx;
    }
}
package br.com.biopids.provider;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		AppContext.setApplicationContext(arg0);

	}

}

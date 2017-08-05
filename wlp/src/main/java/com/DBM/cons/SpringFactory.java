package com.DBM.cons;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringFactory implements ApplicationContextAware {
	private static ApplicationContext context;
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}
	public static Object getObject(String id) {
		Object object = null;
		object = context.getBean(id);
		return object;
	}
}


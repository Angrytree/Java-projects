package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticInfo {
	
	public static final ApplicationContext SERVICE_CONTEXT = new ClassPathXmlApplicationContext("ServiceBeanConfig.xml");
	public static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("MainBeanConfig.xml");
	
	
}

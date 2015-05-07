package com.palamarchuk.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Contexts {
	public static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext(
			"MainBeanConfig.xml");
}

package com.example.aop.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lidongmeng
 * Created on 2022-07-18
 */
public class AopXmlExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) context.getBean("HelloWorldService");
		helloWorldService.sayHello();
	}
}

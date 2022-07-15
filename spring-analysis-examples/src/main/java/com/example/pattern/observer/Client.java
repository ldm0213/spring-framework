package com.example.pattern.observer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lidongmeng
 * Created on 2022-07-12
 */
public class Client {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MyPublisher myPublisher = (MyPublisher) applicationContext.getBean("myPublisher");
		myPublisher.publishEvent(new MyEvent(Client.class));
	}
}
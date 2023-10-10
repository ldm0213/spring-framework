package com.example.cycleDepen;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lidongmeng
 * Created on 2023-05-09
 */
public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.cycleDepen");
		applicationContext.getBean("cycleA");
	}
}

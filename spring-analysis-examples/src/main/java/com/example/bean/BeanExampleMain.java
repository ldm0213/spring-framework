package com.example.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lidongmeng
 * Created on 2022-02-18
 */
public class BeanExampleMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		User user = ctx.getBean(User.class);
		System.out.println("user = " + user);
	}

}

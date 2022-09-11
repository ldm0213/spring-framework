package com.example.aop.helloworld;

/**
 * @author lidongmeng
 * Created on 2022-07-18
 */
public class HelloWorldServiceImpl implements IHelloWorldService {
	@Override
	public void sayHello() {
		System.out.println("Spring AOP——Hello world");
	}
}

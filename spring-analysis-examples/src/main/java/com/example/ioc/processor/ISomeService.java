package com.example.ioc.processor;

/**
 * @author lidongmeng
 * Created on 2022-06-15
 */
public class ISomeService implements BaseService {

	@Override
	public String doSomething() {
		return "Hello AlanShelby";
	}

	@Override
	public String eat() {
		return "eat food";
	}
}

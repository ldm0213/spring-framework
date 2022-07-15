package com.example.pattern.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @author lidongmeng
 * Created on 2022-07-12
 */
public class MyEvent extends ApplicationEvent {

	private static final long serialVersionUID = 5516075349620653481L;

	public MyEvent(Object source) {
		super(source);
		System.out.println("My event");
	}
}
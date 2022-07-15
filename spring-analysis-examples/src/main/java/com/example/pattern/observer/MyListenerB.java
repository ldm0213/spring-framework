package com.example.pattern.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-07-12
 */
@Component
public class MyListenerB implements ApplicationListener<MyEvent> {
	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println("ListenerB received");
	}
}

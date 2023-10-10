package com.example.pattern.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-07-12
 */
@Component
public class MyListenerA {
	@EventListener
	public void onApplicationEvent(MyEvent event) {
		System.out.println("ListenerA received");
	}
}

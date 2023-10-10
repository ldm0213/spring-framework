package com.example.pattern.observer;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-07-12
 */
@Component
public class MyListenerB implements SmartApplicationListener {

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == MyEvent.class;
	}

	@Override
	public int getOrder() {
		return 5;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("ListenerB received");
	}
}

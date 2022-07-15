package com.example.pattern.observer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-07-12
 */
@Component
public class MyPublisher implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void publishEvent(ApplicationEvent event) {
		System.out.println("Publish event");
		applicationContext.publishEvent(event);
	}
}

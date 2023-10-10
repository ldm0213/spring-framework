package com.example.pattern.observer;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

/**
 * @author lidongmeng
 * Created on 2022-07-12
 */
@Configuration
@ComponentScan
public class AppConfig {

	@Bean(name = "myPublisher")
	public MyPublisher myPublisher() {
		return new MyPublisher();
	}

	@Order(value = -1)
	@EventListener(classes = {MyEvent.class})
	public void listener1(ApplicationEvent event) {
		System.out.println("[listener1]事件触发：" + event.getClass().getName());
	}
}
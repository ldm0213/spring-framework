package com.example.pattern.observer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
}

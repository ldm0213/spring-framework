package com.example.aop.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lidongmeng
 * Created on 2022-08-24
 */
public class AspectAopApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
		Object calculator = applicationContext.getBean(MathCalculator.class);
		Object logAspect = applicationContext.getBean(LoggingAspect.class);

		System.out.println(logAspect.getClass().getName());
		System.out.println(calculator.getClass().getName());
		System.out.println(calculator instanceof MathCalculator);

		((MathCalculator) calculator).div(3, 0);
	}
}

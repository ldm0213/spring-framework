package com.example.beandefinition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lidongmeng
 * Created on 2022-07-14
 */
public class RootBeanDefinitionApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		RootBeanDefinition rootBeanDefinitionA = getRootBeanDefinitionByConstruct();
		RootBeanDefinition rootBeanDefinitionB = getRootBeanDefinitionBySetter();

		applicationContext.registerBeanDefinition("rootA", rootBeanDefinitionA);
		applicationContext.registerBeanDefinition("rootB", rootBeanDefinitionB);

		// 这里埋一个点，直到这里才调用了Root对象的构造函数
		applicationContext.refresh();

		Root rootA = ((Root) applicationContext.getBean("rootA"));
		Root rootB = ((Root) applicationContext.getBean("rootB"));
		System.out.println(rootA.toString());
		System.out.println(rootB.toString());
	}

	public static RootBeanDefinition getRootBeanDefinitionByConstruct() {
		ConstructorArgumentValues cargs = new ConstructorArgumentValues();
		cargs.addIndexedArgumentValue(0, "rootA");
		cargs.addIndexedArgumentValue(1, "This is a rootBeanDefinition");
		cargs.addIndexedArgumentValue(2, true);
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Root.class, cargs, null);
		return rootBeanDefinition;
	}

	public static RootBeanDefinition getRootBeanDefinitionBySetter() {
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("name", "rootB");
		propertyValues.addPropertyValue("description", "This is a rootBeanDefinition");
		propertyValues.addPropertyValue("isRoot", true);
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Root.class, null, propertyValues);
		return rootBeanDefinition;
	}
}

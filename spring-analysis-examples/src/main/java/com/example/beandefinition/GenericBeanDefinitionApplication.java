package com.example.beandefinition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lidongmeng
 * Created on 2022-07-14
 */
public class GenericBeanDefinitionApplication {

	public static void main(String[] args) {
		// 1. 构建一个空的容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		GenericBeanDefinition rootBeanDefinition = getRootBeanDefinition();
		GenericBeanDefinition childBeanDefinition = getChildBeanDefinition();
		applicationContext.registerBeanDefinition("root", rootBeanDefinition);
		applicationContext.registerBeanDefinition("child", childBeanDefinition);
		applicationContext.refresh();

		Root root = applicationContext.getBean(Root.class);
		Child child = applicationContext.getBean(Child.class);
		System.out.println(root);
		System.out.println(child);
	}

	public static GenericBeanDefinition getRootBeanDefinition() {
		GenericBeanDefinition rootBeanDefinition = new GenericBeanDefinition();
		rootBeanDefinition.setBeanClass(Root.class);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add("name", "root")
				.add("description", "I am a rootBeanDefinition")
				.add("isRoot", true);
		rootBeanDefinition.setPropertyValues(propertyValues);
		return rootBeanDefinition;
	}

	public static GenericBeanDefinition getChildBeanDefinition() {
		GenericBeanDefinition childBeanDefinition = new GenericBeanDefinition();
		childBeanDefinition.setBeanClass(Child.class);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add("parentName", "root");
		childBeanDefinition.setParentName("root");
		childBeanDefinition.setPropertyValues(propertyValues);
		return childBeanDefinition;
	}
}

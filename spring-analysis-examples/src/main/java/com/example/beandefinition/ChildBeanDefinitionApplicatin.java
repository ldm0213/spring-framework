package com.example.beandefinition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lidongmeng
 * Created on 2022-07-14
 */
public class ChildBeanDefinitionApplicatin {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		String parentName = "rootB";
		String childName = "child";
		RootBeanDefinition rootBeanDefinition = getRootBeanDefinitionBySetter();

		ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition(parentName);
		childBeanDefinition.setBeanClass(Child.class);
		childBeanDefinition.getPropertyValues().addPropertyValue("parentName", parentName);
		childBeanDefinition.getPropertyValues().addPropertyValue("isRoot", false);
		// 注册
		applicationContext.registerBeanDefinition(parentName, rootBeanDefinition);
		applicationContext.registerBeanDefinition(childName, childBeanDefinition);
		// 刷新上下文
		applicationContext.refresh();

		Root root = applicationContext.getBean(Root.class);
		Child child = (Child) applicationContext.getBean(childName);
		System.out.println(root.toString());
		System.out.println(child.toString());
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

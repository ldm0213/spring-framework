package com.example.ioc;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.example.ioc.factory.Car;
import com.example.ioc.pojo.DowJonesNewsListener;
import com.example.ioc.pojo.DowJonesNewsPersister;
import com.example.ioc.pojo.NewsProvider;
import com.example.ioc.processor.BaseService;

/**
 * @author lidongmeng
 * Created on 2022-02-18
 * https://github.com/cccqqf/SpringLearning/blob/master/src/IOC/Main.java
 */
public class IocExampleMain {

	public static void main(String[] args) {
		// beanWrapper();
		// beanGet();
		// beanProcessorExample();
		staticFatoryBeanExample();
	}

	public static void staticFatoryBeanExample() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Car car1 = (Car) ctx.getBean("bmwCar");
		System.out.println(car1);

		car1 = (Car) ctx.getBean("audiCar");
		System.out.println(car1);

		car1 = (Car) ctx.getBean("car4");
		System.out.println(car1);
	}

	public static void beanProcessorExample() {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		BaseService serviceObj = (BaseService) factory.getBean("iSomeService");
		System.out.println(serviceObj.doSomething());
	}

	public static void beanGet() {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();

		// 不同获取container的方法
		// BeanFactory container = hardCodeBeanDef(beanRegistry);
		BeanFactory containerPath = classPathBeanDef(beanRegistry);
		// ApplicationContext containerContext = new ClassPathXmlApplicationContext("classpath:beans.xml");

		NewsProvider provider = (NewsProvider) containerPath.getBean("newsProvider");
		provider.getAndPersistNews();
	}

	public static BeanFactory hardCodeBeanDef(BeanDefinitionRegistry registry) {
		// bean定义
		AbstractBeanDefinition newsProvider = new RootBeanDefinition(NewsProvider.class);
		AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
		AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);

		// 将bean定义注册到容器中
		registry.registerBeanDefinition("newsProvider", newsProvider);
		registry.registerBeanDefinition("newsListener", newsListener);
		registry.registerBeanDefinition("newsPersister", newsPersister);

		// 指定依赖关系
		// 1. constructor方式注入bean
		ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
		argumentValues.addIndexedArgumentValue(0, newsListener);
		argumentValues.addIndexedArgumentValue(1, newsPersister);
		newsProvider.setConstructorArgumentValues(argumentValues);
		// 2. set方式注入bean
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
		propertyValues.addPropertyValue(new PropertyValue("newsPersister", newsPersister));
		newsProvider.setPropertyValues(propertyValues);

		return (BeanFactory) registry;
	}

	public static BeanFactory classPathBeanDef(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:beans.xml");
		return (BeanFactory) registry;
	}

	public static void beanWrapper() {
		try {
			Object newsProvider = Class.forName("com.example.ioc.pojo.NewsProvider").newInstance();
			Object newsListener = Class.forName("com.example.ioc.pojo.DowJonesNewsListener").newInstance();
			Object newsPersister = Class.forName("com.example.ioc.pojo.DowJonesNewsPersister").newInstance();

			BeanWrapper beanWrapper = new BeanWrapperImpl(newsProvider);
			beanWrapper.setPropertyValue("newsListener", newsListener);
			beanWrapper.setPropertyValue("newsPersister", newsPersister);

			Assert.isTrue(beanWrapper instanceof NewsProvider, "not newsprovider");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.framework.adapter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor that registers {@link AdvisorAdapter} beans in the BeanFactory with
 * an {@link AdvisorAdapterRegistry} (by default the {@link GlobalAdvisorAdapterRegistry}).
 *
 * <p>The only requirement for it to work is that it needs to be defined
 * in application context along with "non-native" Spring AdvisorAdapters
 * that need to be "recognized" by Spring's AOP framework.
 *
 * 在bean对象初始化后注册通知适配器，AdvisorAdapterRegistrationManager是BeanPostProcessor的一个实现类，
 * 其主要作用为容器中管理的Bean注册一个面向切面编程的通知适配器，以便在Spring容器为所管理的Bean进行面向切面编程时提供方便
 *
 *
 * @author Dmitriy Kopylenko
 * @author Juergen Hoeller
 * @since 27.02.2004
 * @see #setAdvisorAdapterRegistry
 * @see AdvisorAdapter
 */
public class AdvisorAdapterRegistrationManager implements BeanPostProcessor {

	private AdvisorAdapterRegistry advisorAdapterRegistry = GlobalAdvisorAdapterRegistry.getInstance();


	/**
	 * Specify the AdvisorAdapterRegistry to register AdvisorAdapter beans with.
	 * Default is the global AdvisorAdapterRegistry.
	 * @see GlobalAdvisorAdapterRegistry
	 */
	public void setAdvisorAdapterRegistry(AdvisorAdapterRegistry advisorAdapterRegistry) {
		this.advisorAdapterRegistry = advisorAdapterRegistry;
	}


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AdvisorAdapter){
			this.advisorAdapterRegistry.registerAdvisorAdapter((AdvisorAdapter) bean);
		}
		return bean;
	}

}

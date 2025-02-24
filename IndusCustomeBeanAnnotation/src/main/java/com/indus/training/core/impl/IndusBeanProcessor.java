package com.indus.training.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import com.indus.training.core.config.IndusConfig;

import java.lang.reflect.Method;

@Component
public class IndusBeanProcessor {

	private final IndusConfig indusConfig;
	private DefaultListableBeanFactory beanFactory;

	@Autowired
	public IndusBeanProcessor(IndusConfig indusConfig, DefaultListableBeanFactory beanFactory) {
		this.indusConfig = indusConfig;
		this.beanFactory = beanFactory;
		processIndusBeans();
	}

	private void processIndusBeans() {
		Method[] methods = indusConfig.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(IndusBean.class)) {
				IndusBean annotation = method.getAnnotation(IndusBean.class);
				try {
					Object beanInstance = method.invoke(indusConfig);
					beanFactory.registerSingleton(annotation.value(), beanInstance);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

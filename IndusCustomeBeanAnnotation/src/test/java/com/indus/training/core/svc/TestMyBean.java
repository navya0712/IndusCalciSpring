package com.indus.training.core.svc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indus.training.core.config.IndusConfig;
import com.indus.training.core.impl.IndusBeanProcessor;
import com.indus.training.core.impl.MyBean;

import junit.framework.TestCase;

public class TestMyBean extends TestCase {

	private MyBean myBean;

	protected void setUp() throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(IndusConfig.class);
		IndusBeanProcessor processor = context.getBean(IndusBeanProcessor.class);
		MyBean myBean =(MyBean) context.getBean("myBean");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDisplay() {
		fail("Not yet implemented");
	}

}

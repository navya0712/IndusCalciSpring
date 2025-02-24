package com.indus.training.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.indus.training.core.impl.IndusBean;
import com.indus.training.core.impl.MyBean;

@Configuration
@ComponentScan(basePackages="com.indus.training.core.impl")
public class IndusConfig {

	@IndusBean("myBean")
	public MyBean createMyBean() {
		return new MyBean();
	}
}

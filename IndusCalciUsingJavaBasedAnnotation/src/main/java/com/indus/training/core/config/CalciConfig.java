package com.indus.training.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.indus.training.core.impl.Calci;

@Configuration
public class CalciConfig {

	@Bean
	public Calci calci() {
		return new Calci();
	}
}

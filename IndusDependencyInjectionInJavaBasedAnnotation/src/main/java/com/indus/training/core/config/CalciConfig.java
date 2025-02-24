package com.indus.training.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.indus.training.core.impl.Calci;
import com.indus.training.core.impl.CalciService;

@Configuration
public class CalciConfig {

	@Bean
	public Calci calci() {
		return new Calci();
	}

	@Bean
	public CalciService calciService(Calci calci) {
		return new CalciService(calci);
	}

}

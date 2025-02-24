package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class IndusResumeWebAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(IndusResumeWebAppApplication.class, args);
	}
	 @Bean
	    public ServletRegistrationBean<HelloServlet> helloWorldServlet() {
	        ServletRegistrationBean<HelloServlet> servletRegistrationBean = new ServletRegistrationBean<>(new HelloServlet(), "/helloServlet");
	        servletRegistrationBean.setName("HelloWorldServlet");
	        return servletRegistrationBean;
	    }

}

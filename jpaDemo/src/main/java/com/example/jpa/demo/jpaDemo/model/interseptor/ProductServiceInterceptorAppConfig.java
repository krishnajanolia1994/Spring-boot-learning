package com.example.jpa.demo.jpaDemo.model.interseptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ProductInterseptor productInterseptor;
	
	
	
		@Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(productInterseptor);
	   }
}

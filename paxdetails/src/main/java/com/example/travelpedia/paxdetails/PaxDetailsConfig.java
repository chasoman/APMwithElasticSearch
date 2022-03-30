package com.example.travelpedia.paxdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PaxDetailsConfig implements WebMvcConfigurer{
	
	@Autowired
	private PaxDetailsRequestInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptor).addPathPatterns("/*");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}

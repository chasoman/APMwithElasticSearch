package com.example.travelpedia.paxbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PaxBookingConfig implements WebMvcConfigurer{
	
	@Autowired
	private PaxBookingRequestInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptor).addPathPatterns("/*");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	

}

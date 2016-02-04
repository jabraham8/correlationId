package com.example.test.configuration;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.test.filter.CorrelationFilter;

@Configuration
public class FilterConfiguration {

	@Bean
	public FilterRegistrationBean getCorrelationFilter() {
		
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CorrelationFilter());
		registration.addUrlPatterns("/*");
		registration.setName("correlationFilter");
		
		return registration;
	}
}

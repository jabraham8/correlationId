package com.example.test.configuration;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import com.example.test.interceptor.CorrelationInterceptor;

/**
 * This class is intended to modify the RestTemplate that is created by Ribbon (the autowired one)
 * to include the correlation interceptor that adds the header with the correlationId in the requests
 * 
 * @author abraham
 *
 */
@Configuration
public class RestTemplateConfiguration {

	@Autowired 
	private RestTemplate restTemplate;
	
	@PostConstruct
	public void addInterceptor() {
	
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		interceptors.add(new CorrelationInterceptor());
		restTemplate.setInterceptors(interceptors);
	}
}

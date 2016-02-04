package com.example.test.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.example.test.logback.CorrelationContext;

public class CorrelationFilter implements Filter {

	public static final String CORRELATION_HEADER_NAME = "CorrelationId";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String correlationId = httpServletRequest.getHeader(CORRELATION_HEADER_NAME);
		
		/* If not correlationId exists, we have to create it */
		if (StringUtils.isEmpty(correlationId)) {
			correlationId = UUID.randomUUID().toString();
		}
		
		/* Settle the correlationId for the context */
		CorrelationContext.getContext().setCorrelationId(correlationId);
		
		/* Continue with the execution */
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
}

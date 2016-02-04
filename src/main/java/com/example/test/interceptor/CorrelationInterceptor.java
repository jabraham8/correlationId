package com.example.test.interceptor;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import com.example.test.filter.CorrelationFilter;
import com.example.test.logback.CorrelationContext;

public class CorrelationInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		/* Add the correlationId header for the output requests */
		HttpHeaders headers = request.getHeaders();
		headers.set(CorrelationFilter.CORRELATION_HEADER_NAME, CorrelationContext.getContext().getCorrelationId());
		
		return execution.execute(request, body);
	}
}

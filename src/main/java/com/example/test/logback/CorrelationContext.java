package com.example.test.logback;

public class CorrelationContext {

	private static final ThreadLocal<CorrelationContext> CONTEXT = new ThreadLocal<CorrelationContext>();
	
	private String correlationId;
	
	/**
	 * Retrieve the current context or create a new one if doens't exist
	 * 
	 * @return
	 */
	public static CorrelationContext getContext() {
		
		CorrelationContext result = CONTEXT.get();
		
		if (result == null) {
			result = new CorrelationContext();
			CONTEXT.set(result);
		}
		
		return result;
	}

	public String getCorrelationId() {
		return correlationId;
	}
	
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
}

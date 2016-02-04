package com.example.test.logback;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

public class CorrelationPatternLayoutEncoder extends PatternLayoutEncoder {

	public static final String CORRELATION_PATTERN = "id";
	
	public void start() {

		PatternLayout patternLayout = new PatternLayout();
	    patternLayout.getDefaultConverterMap().put(CORRELATION_PATTERN, CorrelationConverter.class.getName());
	    patternLayout.setContext(context);
	    patternLayout.setPattern(getPattern());
	    patternLayout.setOutputPatternAsHeader(outputPatternAsHeader);	    
	    patternLayout.start();
	    this.layout = patternLayout;
	    this.started = true;
	}
}

package com.example.test.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CorrelationConverter extends ClassicConverter {

	@Override
	public String convert(ILoggingEvent event) {
		
		/* Return the current correlationId stored in the context */
		return CorrelationContext.getContext().getCorrelationId();
	}
}

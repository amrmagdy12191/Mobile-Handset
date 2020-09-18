package com.mobile.handler.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessException extends RuntimeException {
	public static final Logger logger = LoggerFactory.getLogger(BusinessException.class);
	
	private String message;
	private Exception ex;
	
	public BusinessException(Exception ex, String message) {
		super(message);
		this.message = message;	
		logger.error(message, ex );
	}
	
	
}

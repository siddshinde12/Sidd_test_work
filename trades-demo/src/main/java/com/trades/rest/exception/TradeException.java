package com.trades.rest.exception;


/**
* This class work as user defined exception class 
* for Trade functionality .
*
* @author  Siddharth S
* @version 1.0
* @since   2021-04-08 
*/
public class TradeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public TradeException() {
		super();
	}
	
	public TradeException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	
}


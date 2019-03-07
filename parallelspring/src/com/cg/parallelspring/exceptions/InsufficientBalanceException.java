package com.cg.parallelspring.exceptions;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}

}

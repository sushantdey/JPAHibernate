package com.cg.banking.exceptions;

public class AccountDetailsNotFoundException extends Exception {

	public AccountDetailsNotFoundException() {
		super();
	}
	public AccountDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AccountDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public AccountDetailsNotFoundException(String message) {
		super(message);
	}
	public AccountDetailsNotFoundException(Throwable cause) {
		super(cause);
	}
}

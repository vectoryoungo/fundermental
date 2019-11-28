package com.xlab.service_java_infrastructure.bitcoinj.exception;

public class NotSupportException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotSupportException(String message) {
        super(message);
    }
}

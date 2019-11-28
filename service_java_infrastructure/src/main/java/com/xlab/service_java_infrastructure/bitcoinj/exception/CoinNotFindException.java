package com.xlab.service_java_infrastructure.bitcoinj.exception;

public class CoinNotFindException extends Exception {
	private static final long serialVersionUID = 1L;

	public CoinNotFindException(String message) {
        super(message);
    }
}

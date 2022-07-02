package com.productapp.exceptions;

public class ProductAppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductAppException(String message) {
		super(message);
	}

}

package com.bnauk.bbcron.exceptions;

/**
 * BadRequestException
 * @author benauca
 */
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(msg);
	}

}
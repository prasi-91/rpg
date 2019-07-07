/*
 * Author M S Prasita Nair
 * 
 * Exception Class for Character Service Exceptions
 * 
 */

package com.rpg.exception;

public class CharacterServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CharacterServiceException(String message) {
		super(message);
	}

	public CharacterServiceException(String message, Throwable t) {
		super(message, t);
	}

}

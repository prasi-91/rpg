package com.rpg.exception;

public class GameServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameServiceException(String message) {
		super(message);
	}

	public GameServiceException(String message, Throwable t) {
		super(message, t);
	}

}

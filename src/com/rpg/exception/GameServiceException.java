package com.rpg.exception;

public class GameServiceException extends RuntimeException {

  public GameServiceException(String message) {
    super(message);
  }

  public GameServiceException(String message, Throwable t) {
    super(message, t);
  } 

}

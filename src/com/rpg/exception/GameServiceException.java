package com.rpg.exception;

public class GameServiceException extends Exception {

  public GameServiceException(String message) {
    super(message);
  }

  public GameServiceException(String message, Throwable t) {
    super(message, t);
  } 

}

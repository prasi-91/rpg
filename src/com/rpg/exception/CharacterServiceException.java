package com.rpg.exception;

public class CharacterServiceException extends RuntimeException {

  public CharacterServiceException(String message) {
    super(message);
  }   

  public CharacterServiceException(String message, Throwable t) {
      super(message, t);
  }

}

package org.example.taskmanager.controller.exceptions;

public class BadCreateTaskException extends RuntimeException {
  public BadCreateTaskException(String message) {
    super(message);
  }
}

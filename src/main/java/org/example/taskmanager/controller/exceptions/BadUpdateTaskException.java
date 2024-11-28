package org.example.taskmanager.controller.exceptions;

public class BadUpdateTaskException extends RuntimeException {
    public BadUpdateTaskException(String message) {
        super(message);
    }
}

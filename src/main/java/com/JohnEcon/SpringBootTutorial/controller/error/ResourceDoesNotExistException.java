package com.JohnEcon.SpringBootTutorial.controller.error;


public class ResourceDoesNotExistException extends RuntimeException{

    public ResourceDoesNotExistException() {
        super();
    }

    public ResourceDoesNotExistException(String message) {
        super(message);
    }

    public ResourceDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceDoesNotExistException(Throwable cause) {
        super(cause);
    }

    protected ResourceDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

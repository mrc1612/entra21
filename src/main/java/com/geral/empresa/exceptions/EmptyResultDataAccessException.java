package com.geral.empresa.exceptions;

public class EmptyResultDataAccessException extends RuntimeException{

    public EmptyResultDataAccessException(String message) {
        super(message);
    }

    public EmptyResultDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    
}

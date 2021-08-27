package com.challenge.altimetrik.exceptions;

import lombok.Getter;

@Getter
public class UnexpectedException extends RuntimeException{
    private Exception exception;
    public UnexpectedException(Exception exception) {
        super(exception);
        this.exception = exception;
    }
}

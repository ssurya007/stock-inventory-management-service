package com.challenge.altimetrik.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private Exception exception;
    public BusinessException(Exception exception) {
        super(exception);
        this.exception = exception;
    }
}

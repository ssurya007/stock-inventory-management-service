package com.challenge.altimetrik.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateResourceException extends RuntimeException {
    private Exception exception;
    public DuplicateResourceException(Exception exception) {
        super(exception);
        this.exception = exception;
    }
}

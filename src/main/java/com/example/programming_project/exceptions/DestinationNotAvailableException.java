package com.example.programming_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DestinationNotAvailableException extends RuntimeException {
    public DestinationNotAvailableException(String message) {
        super(message);
    }
}
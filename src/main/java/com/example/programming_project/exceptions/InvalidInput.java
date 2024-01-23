package com.example.programming_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidInput extends RuntimeException {
    public InvalidInput(String message) {
        super(message);
    }
}

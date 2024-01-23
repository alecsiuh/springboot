package com.example.programming_project.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message, Throwable cause){
        super(message, cause);
    }
}

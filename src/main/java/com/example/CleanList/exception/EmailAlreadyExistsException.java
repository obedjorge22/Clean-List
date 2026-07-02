package com.example.CleanList.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException() {
        super("Email already exists.");
    }

    public EmailAlreadyExistsException(String email) {
        super("Email '" + email + "' is already registered.");
    }
}
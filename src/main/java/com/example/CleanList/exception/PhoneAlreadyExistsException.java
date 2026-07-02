package com.example.CleanList.exception;

public class PhoneAlreadyExistsException extends RuntimeException {

    public PhoneAlreadyExistsException() {
        super("Phone number already exists.");
    }

    public PhoneAlreadyExistsException(String phone) {
        super("Phone number '" + phone + "' is already registered.");
    }}

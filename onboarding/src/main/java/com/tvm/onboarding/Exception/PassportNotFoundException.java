package com.tvm.onboarding.Exception;

public class PassportNotFoundException extends RuntimeException{
    public PassportNotFoundException(String message) {
        super(message);
    }
}

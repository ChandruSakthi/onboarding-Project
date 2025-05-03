package com.tvm.onboarding.Exception;

public class PersonalNotFoundException extends RuntimeException{
    public PersonalNotFoundException(String message) {
        super(message);
    }
}

package com.tvm.onboarding.Exception;

public class KYCNotFoundException extends RuntimeException{
    public KYCNotFoundException(String message) {
        super(message);
    }
}

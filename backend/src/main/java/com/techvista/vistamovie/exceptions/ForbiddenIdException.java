package com.techvista.vistamovie.exceptions;

public class ForbiddenIdException extends RuntimeException {
    public ForbiddenIdException(String message) {
        super(message);
    }
}

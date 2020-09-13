package com.d0rj.exception;


public class InvalidInnException extends Exception {

    public InvalidInnException() {
        super("Invalid INN.");
    }


    public InvalidInnException(String message) {
        super("Invalid INN. Message: '" + message + " '.");
    }
}

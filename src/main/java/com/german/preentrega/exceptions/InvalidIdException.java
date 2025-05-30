package com.german.preentrega.exceptions;

public class InvalidIdException extends Exception {
    public InvalidIdException() {
        super("El id es invalido.");
    }
    public InvalidIdException(String message) {
        super(message);
    }
}

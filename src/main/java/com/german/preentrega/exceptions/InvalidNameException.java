package com.german.preentrega.exceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException() {
        super("El nombre del producto no es valido.");
    }
    public InvalidNameException(String message) {
        super(message);
    }
}

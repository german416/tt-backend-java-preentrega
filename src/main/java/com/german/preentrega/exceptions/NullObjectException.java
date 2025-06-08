package com.german.preentrega.exceptions;

public class NullObjectException extends Exception {
    public NullObjectException() {
        super("Me estas pasando un objeto nulo.");
    }
    public NullObjectException(String message) {
        super(message);
    }
}

package com.german.preentrega.exceptions;

public class DuplicateIndexException extends Exception {
    public DuplicateIndexException() {
        super("El índice ya existe.");
    }
    public DuplicateIndexException(String message) {
        super(message);
    }
}

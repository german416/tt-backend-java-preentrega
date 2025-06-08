package com.german.preentrega.exceptions;

public class OutOfStockException extends Exception {
    public OutOfStockException() {
        super("Stock insuficiente.");
    }
    public OutOfStockException(String message) {
        super(message);
    }
}

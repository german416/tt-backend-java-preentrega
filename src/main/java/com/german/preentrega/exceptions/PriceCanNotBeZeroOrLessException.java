package com.german.preentrega.exceptions;

public class PriceCanNotBeZeroOrLessException extends Exception {
    public PriceCanNotBeZeroOrLessException() {
        super("El precio debe ser mayor a 0.");
    }
    public PriceCanNotBeZeroOrLessException(String message) {
        super(message);
    }
}

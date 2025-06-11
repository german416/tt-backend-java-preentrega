package com.german.preentrega.exceptions;

public class StockCanNotBeZeroOrLessException extends Exception {
    public StockCanNotBeZeroOrLessException() {
        super("El stock debe ser mayor a 0.");
    }
    public StockCanNotBeZeroOrLessException(String message) {
        super(message);
    }
}

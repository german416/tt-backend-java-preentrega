package com.german.preentrega.ui;

public class Option {
    private String message;
    private Character index;
    private Action action;

    public Option(String message, Character index, Action action) {
        this.message = message;
        this.index = index;
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public char getIndex() {
        return index;
    }

    public void setIndex(Character index) {
        this.index = index;
    }

    public String getLabel() {
        String result;
        result = "[" + index + "] " + message;
        return result;
    }

    public void run() {
        action.execute();
    }
}

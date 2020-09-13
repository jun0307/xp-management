package com.platform.cloud.xpmanagement.common.exception;

public class InvalidInputException extends RuntimeException {

    private String msg;

    public InvalidInputException(String msg) {
        this.msg = msg;
    }

    public InvalidInputException(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

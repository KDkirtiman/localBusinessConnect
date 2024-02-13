package com.lbc.localbusinessconnect.exception;

import lombok.Data;

@Data
public class BaseException extends Exception {

    private String errorType;
    private String errorMsg;

    public BaseException() {}

    public BaseException (String errorType, String errorMsg, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
        this.errorMsg = errorMsg;
    }

    public BaseException (String errorType, String errorMsg, String message) {
        super(message);
        this.errorType = errorType;
        this.errorMsg = errorMsg;
    }

    public BaseException (String errorType, String errorMsg) {
        super(errorMsg);
        this.errorType = errorType;
        this.errorMsg = errorMsg;
    }

    public BaseException (Throwable cause) {
        super(cause);
    }
}

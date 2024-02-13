package com.lbc.localbusinessconnect.exception;

public class EntityServiceException extends BaseException {

    public EntityServiceException() {}

    public EntityServiceException(String errorType, String errorMsg, String message, Throwable cause) {
        super(errorType, errorMsg, message, cause);
    }

    public EntityServiceException(String errorType, String errorMsg, String message) {
        super(errorType, errorMsg, message);
    }

    public EntityServiceException(String errorType, String errorMsg) {
        super(errorType, errorMsg);
    }

    public EntityServiceException(Throwable cause) {
        super(cause);
    }
}

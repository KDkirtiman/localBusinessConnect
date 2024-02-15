package com.lbc.localbusinessconnect.model.response;

import lombok.Data;

@Data
public class ErrorResponse {

    public String errorCode;
    public String errorMsg;

    public String message;

    public ErrorResponse(String errorCode, String errorMsg, String message) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.message = message;
    }
}

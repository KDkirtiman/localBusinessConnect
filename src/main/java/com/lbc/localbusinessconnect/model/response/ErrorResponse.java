package com.lbc.localbusinessconnect.model.response;

import lombok.Data;

@Data
public class ErrorResponse {

    public String errorCode;
    public String errorMsg;
}

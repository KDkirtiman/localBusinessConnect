package com.lbc.localbusinessconnect.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class GenericResponse implements Serializable {
    Boolean transactionSuccess;
    ErrorResponse error;
}

package com.lbc.localbusinessconnect.model;

import lombok.Data;

@Data
public class UserCredentialDetails {

    String userId;
    String password;
    String accountType;
    String accountStatus;
}

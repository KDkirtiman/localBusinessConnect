package com.lbc.localbusinessconnect.model;

import lombok.Data;

@Data
public class UserCredential {

    String userId;
    String password;
    String accountType;
    String accountStatus;
}

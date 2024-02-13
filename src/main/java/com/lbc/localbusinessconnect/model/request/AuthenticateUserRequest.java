package com.lbc.localbusinessconnect.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateUserRequest {
    String userName;
    String password;
}

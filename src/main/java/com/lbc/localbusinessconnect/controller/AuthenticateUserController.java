package com.lbc.localbusinessconnect.controller;

import com.lbc.localbusinessconnect.mapper.authenticate.AuthenticateUserMapper;
import com.lbc.localbusinessconnect.model.request.AuthenticateUserRequest;
import com.lbc.localbusinessconnect.model.response.AuthenticateUserResponse;
import com.lbc.localbusinessconnect.repository.authenticate.AuthenticateUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthenticateUserController {

    @Autowired
    AuthenticateUserRepository repository;

    @GetMapping("/authenticateUser")
    public AuthenticateUserResponse authenticateUser(@RequestBody AuthenticateUserRequest request) {
        log.info("User logged in : {}",request.getUserName());
        AuthenticateUserRequest request1 = repository.authenticateUser(request.getUserName());
        AuthenticateUserResponse response = new AuthenticateUserResponse();
        response.setTransactionSuccess(true);
        return response;
    }

}

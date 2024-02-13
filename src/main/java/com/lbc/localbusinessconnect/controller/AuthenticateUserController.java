package com.lbc.localbusinessconnect.controller;

import com.lbc.localbusinessconnect.exception.EntityServiceException;
import com.lbc.localbusinessconnect.mapper.authenticate.AuthenticateUserMapper;
import com.lbc.localbusinessconnect.model.request.AuthenticateUserRequest;
import com.lbc.localbusinessconnect.model.response.AuthenticateUserResponse;
import com.lbc.localbusinessconnect.repository.authenticate.AuthenticateUserRepository;
import com.lbc.localbusinessconnect.service.authenticate.AuthenticateUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthenticateUserController {

    @Autowired
    AuthenticateUserService authenticateUserService;

    @GetMapping("/authenticateUser")
    public AuthenticateUserResponse authenticateUser(@RequestBody AuthenticateUserRequest request) throws EntityServiceException {
        log.info("User logged in : {}",request.getUserName());
        Boolean authenticateUser = authenticateUserService.authenticateUser(request);
        AuthenticateUserResponse response = new AuthenticateUserResponse();
        response.setTransactionSuccess(authenticateUser);
        return response;
    }

}

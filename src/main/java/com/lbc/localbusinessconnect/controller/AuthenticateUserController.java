package com.lbc.localbusinessconnect.controller;

import com.lbc.localbusinessconnect.exception.EntityServiceException;
import com.lbc.localbusinessconnect.mapper.authenticate.AuthenticateUserMapper;
import com.lbc.localbusinessconnect.model.request.AuthenticateUserRequest;
import com.lbc.localbusinessconnect.model.response.AuthenticateUserResponse;
import com.lbc.localbusinessconnect.model.response.ErrorResponse;
import com.lbc.localbusinessconnect.repository.authenticate.AuthenticateUserRepository;
import com.lbc.localbusinessconnect.service.authenticate.AuthenticateUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/autheticate")
public class AuthenticateUserController {

    @Autowired
    AuthenticateUserService authenticateUserService;

    @PostMapping("/user")
    public AuthenticateUserResponse authenticateUser(@RequestBody AuthenticateUserRequest request) {

        AuthenticateUserResponse response = new AuthenticateUserResponse();
        try{
            log.info("User logged in : {}",request.getUserName());
            Boolean authenticateUser = authenticateUserService.authenticateUser(request);
            response.setTransactionSuccess(authenticateUser);
            return response;
        } catch(EntityServiceException exception ){
            log.error("Error while authenticating user : {}", exception.getMessage());
            response.setError(new ErrorResponse(exception.getErrorType(), exception.getErrorMsg()));
            response.setTransactionSuccess(Boolean.FALSE);
            return response;
        }
    }



    @PostMapping("/registerUserCredentials")
    public AuthenticateUserResponse registerUserCredentials(@RequestBody AuthenticateUserRequest request) {

        AuthenticateUserResponse response = new AuthenticateUserResponse();
        try{
            log.info("User logged in : {}",request.getUserName());
            authenticateUserService.registerUserCredentials(request);
            response.setTransactionSuccess(true);
            return response;
        } catch(EntityServiceException exception ){
            log.error("Error while authenticating user", exception);
            response.setError(new ErrorResponse(exception.getErrorType(), exception.getErrorMsg()));
            response.setTransactionSuccess(Boolean.FALSE);
            return response;
        }
    }

}

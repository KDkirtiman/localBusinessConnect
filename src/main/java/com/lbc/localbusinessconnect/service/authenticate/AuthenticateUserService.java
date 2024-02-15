package com.lbc.localbusinessconnect.service.authenticate;

import com.lbc.localbusinessconnect.constant.ErrorConstant;
import com.lbc.localbusinessconnect.exception.EntityServiceException;
import com.lbc.localbusinessconnect.model.UserCredential;
import com.lbc.localbusinessconnect.model.request.AuthenticateUserRequest;
import com.lbc.localbusinessconnect.repository.authenticate.AuthenticateUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;

@Slf4j
public class AuthenticateUserService {

    @Autowired
    AuthenticateUserRepository authenticateUserRepository;

    public AuthenticateUserService(AuthenticateUserRepository authenticateUserRepository) {
        this.authenticateUserRepository = authenticateUserRepository;
    }

    public Boolean authenticateUser(AuthenticateUserRequest request) throws EntityServiceException {
        try {
            AuthenticateUserRequest userCredential = authenticateUserRepository.authenticateUser(request.getUserName());
            if (ObjectUtils.isEmpty(userCredential)) {
                throw new EntityServiceException(ErrorConstant.AUTHENTICATE_SERVICE_EXCEPTION,ErrorConstant.AUTHENTICATE_NO_USER_FOUND,"NO USER FOUND exception");
            } else {
                if(userCredential.getPassword().equals(request.getPassword())) {
                    return Boolean.TRUE;
                } else {
                    throw new EntityServiceException(ErrorConstant.AUTHENTICATE_SERVICE_EXCEPTION,ErrorConstant.AUTHENTICATE_PASSWORD_INCORRECT,"Incorrect Password entered");
                }
            }
        } catch (EntityServiceException exception) {
            log.error("Error while authenticating user : {}", exception);
            throw new EntityServiceException(exception.getErrorType(), exception.getErrorMsg(), exception.getMessage());
        }
    }

    public void registerUserCredentials(AuthenticateUserRequest request) throws EntityServiceException {
        try {
            UserCredential userCredential = new UserCredential();
            authenticateUserRepository.registerUserCredentials(userCredential);
        } catch (SQLException ex) {
            log.error("Error while inserting user credentials : {}", ex.getMessage());
            throw new EntityServiceException(ErrorConstant.AUTHENTICATE_SERVICE_EXCEPTION,ErrorConstant.USER_REGISTRATION_FAILURE,"USER REGISTRATION Exception");
        }
    }
}

package com.lbc.localbusinessconnect.service.authenticate;

import com.lbc.localbusinessconnect.constant.ErrorConstant;
import com.lbc.localbusinessconnect.exception.EntityServiceException;
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
                    return Boolean.FALSE;
                }
            }
        } catch (Exception exception) {
            log.error("Error while authenticating user", exception);
            throw new EntityServiceException(ErrorConstant.AUTHENTICATE_SERVICE_EXCEPTION,ErrorConstant.AUTHENTICATE_NO_USER_FOUND,"NO USER FOUND exception");
        }
    }
}

package com.lbc.localbusinessconnect.service.authenticate;

import com.lbc.localbusinessconnect.constant.ErrorConstant;
import com.lbc.localbusinessconnect.exception.EntityServiceException;
import com.lbc.localbusinessconnect.model.UserCredentialDetails;
import com.lbc.localbusinessconnect.model.request.UserCredentialRequest;
import com.lbc.localbusinessconnect.repository.authenticate.AuthenticateUserRepository;
import com.lbc.localbusinessconnect.util.Transformer;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;

@Slf4j
public class AuthenticateUserService {

    @Autowired
    AuthenticateUserRepository authenticateUserRepository;

    @Autowired
    Transformer transformer;

    public AuthenticateUserService(AuthenticateUserRepository authenticateUserRepository) {
        this.authenticateUserRepository = authenticateUserRepository;
    }

    public Boolean authenticateUser(UserCredentialRequest request) throws EntityServiceException {
        try {
            UserCredentialRequest userCredential = authenticateUserRepository.authenticateUser(request.getUserName());
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

    public void registerUserCredentials(UserCredentialRequest request) throws EntityServiceException {
        try {
            UserCredentialDetails userCredentialDetails = transformer.getUserCredentialsDetails(
                    request.getUserName(), request.getPassword(), "customer", "active"
            );
            authenticateUserRepository.registerUserCredentials(userCredentialDetails);
        } catch (Exception ex) {
            log.error("Error while inserting user credentials : {}", ex.getMessage());
            throw new EntityServiceException(ErrorConstant.AUTHENTICATE_SERVICE_EXCEPTION,ErrorConstant.USER_REGISTRATION_FAILURE,"username "+request.getUserName()+" already present");
        }
    }
}

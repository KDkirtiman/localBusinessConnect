package com.lbc.localbusinessconnect.mapper.authenticate;

import com.lbc.localbusinessconnect.model.UserCredentialDetails;
import com.lbc.localbusinessconnect.model.request.UserCredentialRequest;
import oracle.jdbc.OracleDatabaseException;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface AuthenticateUserMapper {

    UserCredentialRequest authenticateUser(@Param("userName") String userName);

    void registerUserCredentials(@Param("userCredentialDetails") UserCredentialDetails userCredentialDetails) throws Exception;
}

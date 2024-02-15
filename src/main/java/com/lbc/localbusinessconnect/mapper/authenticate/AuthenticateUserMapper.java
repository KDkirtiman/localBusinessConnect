package com.lbc.localbusinessconnect.mapper.authenticate;

import com.lbc.localbusinessconnect.model.UserCredential;
import com.lbc.localbusinessconnect.model.request.AuthenticateUserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface AuthenticateUserMapper {

    AuthenticateUserRequest authenticateUser(@Param("userName") String userName);

    void registerUserCredentials(@Param("userCredential") UserCredential userCredential) throws SQLException;
}

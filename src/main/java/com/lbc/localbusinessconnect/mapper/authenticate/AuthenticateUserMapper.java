package com.lbc.localbusinessconnect.mapper.authenticate;

import com.lbc.localbusinessconnect.model.request.AuthenticateUserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface AuthenticateUserMapper {

    AuthenticateUserRequest authenticateUser(@Param("userName") String userName);
}

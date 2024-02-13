package com.lbc.localbusinessconnect.repository.authenticate;

import com.lbc.localbusinessconnect.mapper.authenticate.AuthenticateUserMapper;
import com.lbc.localbusinessconnect.model.request.AuthenticateUserRequest;
import com.lbc.localbusinessconnect.repository.MyBatisRepository;
import org.apache.ibatis.session.SqlSession;

public class AuthenticateUserRepository extends MyBatisRepository<AuthenticateUserMapper> {

    AuthenticateUserMapper authenticateUserMapper;
    public AuthenticateUserRepository(SqlSession sqlSession) {
        super(AuthenticateUserMapper.class, sqlSession);
        this.authenticateUserMapper = sqlSession.getMapper(AuthenticateUserMapper.class);
    }

    public AuthenticateUserRequest authenticateUser(String userName) {
        return authenticateUserMapper.authenticateUser(userName);
    }

}

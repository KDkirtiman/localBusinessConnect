package com.lbc.localbusinessconnect.repository.authenticate;

import com.lbc.localbusinessconnect.mapper.authenticate.AuthenticateUserMapper;
import com.lbc.localbusinessconnect.model.UserCredentialDetails;
import com.lbc.localbusinessconnect.model.request.UserCredentialRequest;
import com.lbc.localbusinessconnect.repository.MyBatisRepository;
import oracle.jdbc.OracleDatabaseException;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class AuthenticateUserRepository extends MyBatisRepository<AuthenticateUserMapper> {

    AuthenticateUserMapper authenticateUserMapper;
    public AuthenticateUserRepository(SqlSession sqlSession) {
        super(AuthenticateUserMapper.class, sqlSession);
        this.authenticateUserMapper = sqlSession.getMapper(AuthenticateUserMapper.class);
    }

    public UserCredentialRequest authenticateUser(String userName) {
        return authenticateUserMapper.authenticateUser(userName);
    }

    public void registerUserCredentials(UserCredentialDetails userCredentialDetails) throws Exception {
        authenticateUserMapper.registerUserCredentials(userCredentialDetails);
    }

}

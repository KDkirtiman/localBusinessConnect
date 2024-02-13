package com.lbc.localbusinessconnect.config;

import com.lbc.localbusinessconnect.mapper.authenticate.AuthenticateUserMapper;
import com.lbc.localbusinessconnect.repository.authenticate.AuthenticateUserRepository;
import com.lbc.localbusinessconnect.service.authenticate.AuthenticateUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalBusinessConnectConfiguration {

    @Bean
    public AuthenticateUserService authenticateUserService(AuthenticateUserRepository authenticateUserRepository) {
        return new AuthenticateUserService(authenticateUserRepository);
    }

    @Bean
    public AuthenticateUserRepository authenticateUserRepository(@Qualifier("sqlSession") SqlSession sqlSession) {
        return new AuthenticateUserRepository(sqlSession);
    }

}

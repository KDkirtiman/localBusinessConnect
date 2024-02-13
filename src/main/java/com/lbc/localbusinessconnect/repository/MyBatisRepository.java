package com.lbc.localbusinessconnect.repository;

import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;

public class MyBatisRepository<T> {
    public MyBatisRepository(Class<T> mapper, SqlSession... sqlSessions) {
        Arrays.stream(sqlSessions).forEach((s) -> {
            s.getConfiguration().addMapper(mapper);
        });
    }
}

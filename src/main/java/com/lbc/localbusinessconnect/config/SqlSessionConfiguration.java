package com.lbc.localbusinessconnect.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class SqlSessionConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("KDADMIN");
        dataSource.setPassword("admin12345");
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        log.debug("Creating SqlSessionFactory !!!");
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
            return sqlSessionFactory;
        } catch(Exception var4) {
            log.error("Exception in SqlSessionFactory creation", var4);
            throw new RuntimeException("Exception in SqlSessionFactory creation", var4);
        }
    }

    @Bean("sqlSession")
    public SqlSession sqlSession(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        log.debug("Creating batchSqlSession");
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
    }
}

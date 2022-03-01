package com.netsurfingzone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.netsurfingzone.repository")
public class Config {

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;

        Context ctx = null;
        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/springbootdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }



}

package com.HostelManagement.api.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://localhost\\\\\\\\SQLEXPRESS:1433;databaseName=HostelManagement");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("admin@123");
        return dataSourceBuilder.build();
    }
}
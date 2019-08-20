package com.mso.base.cloud.product.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Data
@ConfigurationProperties(prefix = "sjdb1.datasource")
@Component
public class DB1Config {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String databaseName;

    public DataSource createDataSource() {
        HikariDataSource result = new HikariDataSource();
        result.setDriverClassName(getDriverClassName());
        result.setJdbcUrl(getUrl());
        result.setUsername(getUsername());
        result.setPassword(getPassword());
        return result;
    }

}

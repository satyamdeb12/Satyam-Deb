package com.SpringCoreAssignment.q6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:dbConfig.properties")
public class Config {

    @Value("${database.driverName}")
    private String driverName;
    @Value("${database.url}")
    private String driverUrl;
    @Value("${database.userName}")
    private String userName;
    @Value("${database.password}")
    private String password;


    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DatabaseDetails databaseDetails(){
        DatabaseDetails d = new DatabaseDetails();
        d.setDriverName(driverName);
        d.setDriverUrl(driverUrl);
        d.setUserName(driverName);
        d.setPassword(password);
        return d;
    }


}

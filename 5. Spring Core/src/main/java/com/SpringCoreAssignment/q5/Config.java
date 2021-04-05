package com.SpringCoreAssignment.q5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Address address1(){
        Address address = new Address();
        address.setStreet("xyz");
        address.setState("ABC");
        return address;
    }

    @Bean
    public Address address2(){
        Address address = new Address();
        address.setStreet("my street");
        address.setState("my state");
        return address;
    }

    @Bean
    public Student student(){
        Student student = new Student();
        student.setId(1);
        student.setName("amit");

        return student;
    }


}

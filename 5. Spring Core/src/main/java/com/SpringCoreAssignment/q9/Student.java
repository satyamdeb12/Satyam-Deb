package com.SpringCoreAssignment.q9;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student implements InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initMethod(){
        System.out.println("Called from init method");
    }

    public void destroyMethod(){
        System.out.println("Called from destroy method");
    }

    @PostConstruct
    public void postConstructMethod(){
        System.out.println("Called from post construct method");
    }

    @PreDestroy
    public void preConstructMethod(){
        System.out.println("Called from pre destroy method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Called from disposable bean method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Called from initializing bean method");
    }
}

package com.SpringCoreAssignment.q8;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student{
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
}

package com.SpringCoreAssignment.q5;

import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import javax.inject.Inject;

public class Student {


    private int id;
    private String name;

    @Inject
    private Address address1;

    @Resource
    private Address address2;

    public int getId() {
        return id;
    }

    @Required
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }
}

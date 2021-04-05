package com.SpringCoreAssignment.q6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DisplayDetails {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DatabaseDetails databaseDetails = (DatabaseDetails) context.getBean("databaseDetails");
        System.out.println(databaseDetails);
    }
}

package com.SpringCoreAssignment.q9;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

        public static void main(String[] args) {
            AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCoreAssignment/q9/q9.xml");
            context.registerShutdownHook();
            Student student = (Student) context.getBean("student");
            System.out.println(student.getName());
        }

}

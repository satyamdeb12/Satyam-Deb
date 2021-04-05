package com.SpringCoreAssignment.q1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCoreAssignment/q1/q1.xml");
		Customer customer = (Customer) context.getBean("customerBeanGetter");
		System.out.println(customer);

	}
}

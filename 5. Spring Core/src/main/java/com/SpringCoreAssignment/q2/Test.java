package com.SpringCoreAssignment.q2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCoreAssignment/q2/q2.xml");
		Question question = (Question) context.getBean("question");
		System.out.println(question);
	}
}

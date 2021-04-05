package com.SpringCoreAssignments.q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringCoreAssignment.q1.Customer;

class Q1Test {

	
	@Test
	void testCustomerIdGetter() {
		ApplicationContext contextTest = new ClassPathXmlApplicationContext("com/SpringCoreAssignment/q1/q1.xml");
		Customer customer = (Customer) contextTest.getBean("customerBeanGetter");
		
		assertEquals(101,customer.getCustomerId());
	}
	
	

}

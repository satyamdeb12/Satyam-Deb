package com.SpringCoreAssignments.q4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringCoreAssignment.q4.BankAccountController;
import com.SpringCoreAssignment.q4.config;

class Q4Test {

	

	@Test
	void test() {
		ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
        BankAccountController controller = context.getBean(BankAccountController.class);
        assertEquals(100000.0, controller.getBalance(2));
	}

}

package com.SpringCoreAssignments.q3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringCoreAssignment.q3.BankAccountController;

class Q3Test {

	@Test
    void getBalance() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCoreAssignment/q3/q3.xml");
        BankAccountController controller = (BankAccountController) context.getBean("controller");
        assertEquals(10000,controller.getBalance(1));
    }

}

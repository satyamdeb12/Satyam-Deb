package com.SpringCoreAssignment.q4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
        BankAccountController controller = context.getBean(BankAccountController.class);
        System.out.println(controller.getBalance(2));
    }
}

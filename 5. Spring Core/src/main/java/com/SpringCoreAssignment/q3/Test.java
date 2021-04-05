package com.SpringCoreAssignment.q3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCoreAssignment/q3/q3.xml");
        BankAccountController controller = (BankAccountController) context.getBean("controller");
        System.out.println(controller.getBalance(1));
        System.out.println(controller.getBalance(2));
        
        
//        controller.withdraw(2, 10000);
//        System.out.println("After Withdrawing 10,000 from account 2");
//        System.out.println(controller.getBalance(1));
//        System.out.println(controller.getBalance(2));
        
        controller.fundTransfer(2, 1, 90000);
        System.out.println("After Transferring 90,000 from account 2 to account 1");
        System.out.println(controller.getBalance(1));
        System.out.println(controller.getBalance(2));
        
        
        
    }
}

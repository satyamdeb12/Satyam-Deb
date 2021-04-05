package com.SpringCoreAssignment.q4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class config {

    @Bean
    public BankAccount bankAccount1(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountHolderName("vamsi");
        bankAccount.setAccountId(1);
        bankAccount.setAccountType("savings");
        bankAccount.setAccountBalance(10000);
        return bankAccount;
    }

    @Bean
    public BankAccount bankAccount2(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountHolderName("krishna");
        bankAccount.setAccountId(2);
        bankAccount.setAccountType("savings");
        bankAccount.setAccountBalance(100000);
        return bankAccount;
    }

    @Bean
    public BankAccountRepositoryImpl repo(){
        return new BankAccountRepositoryImpl();
    }

    @Bean
    public List<BankAccount> accounts(){
        List<BankAccount> list = new ArrayList<>();
        list.add(bankAccount1());
        list.add(bankAccount2());
        return list;
    }

    @Bean
    public BankAccountServiceImpl bankService(){
        return new BankAccountServiceImpl();
    }



    @Bean
    public BankAccountController controller(){
        return new BankAccountController();
    }



}

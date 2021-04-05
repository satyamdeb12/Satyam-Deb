package com.SpringCoreAssignment.q4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BankAccountController {

    @Autowired
    private BankAccountServiceImpl bankService;



    public BankAccountServiceImpl getBankService() {
        return bankService;
    }

    public void setBankService(BankAccountServiceImpl bankService) {
        this.bankService = bankService;
    }

    public double withdraw(long accountId, double balance){
        return bankService.withdraw(accountId,balance);
    }
    public double deposit(long accountId, double balance){
        return bankService.deposit(accountId,balance);
    }
    public double getBalance(long accountId){
        return bankService.getBalance(accountId);
    }
    public boolean fundTransfer(long fromAccount, long toAccount, double amount){
        return bankService.fundTransfer(fromAccount,toAccount,amount);
    }


}

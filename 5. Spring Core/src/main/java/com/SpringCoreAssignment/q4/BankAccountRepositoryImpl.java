package com.SpringCoreAssignment.q4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

    List<BankAccount> accounts = new ArrayList<>();

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    @Autowired
    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public BankAccount getAccount(long accountId){
        return this.accounts.stream()
                .filter(x->x.getAccountId()==accountId)
                .findFirst()
                .get();
    }

    @Override
    public double getBalance(long accountId) {
        return getAccount(accountId).getAccountBalance();
    }

    @Override
    public double updateBalance(long accountId, double newBalance) {
        getAccount(accountId)
                .setAccountBalance(getAccount(accountId)
                        .getAccountBalance()+newBalance);
        return getBalance(accountId);
    }
}

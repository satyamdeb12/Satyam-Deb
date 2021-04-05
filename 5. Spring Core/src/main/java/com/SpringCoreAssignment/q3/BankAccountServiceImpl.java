package com.SpringCoreAssignment.q3;

public class BankAccountServiceImpl implements BankAccountService{

    private BankAccountRepositoryImpl repo;

    public BankAccountRepositoryImpl getRepo() {
        return repo;
    }

    public void setRepo(BankAccountRepositoryImpl repo) {
        this.repo = repo;
    }

    @Override
    public double withdraw(long accountId, double balance) {
        if(repo.getBalance(accountId)>=balance){
            return repo.updateBalance(accountId,repo.getBalance(accountId)-balance);
        }
        return repo.getBalance(accountId);

    }

    @Override
    public double deposit(long accountId, double balance) {
        return repo.updateBalance(accountId,repo.getBalance(accountId)+balance);
    }

    @Override
    public double getBalance(long accountId) {
        return repo.getBalance(accountId);
    }

    @Override
    public boolean fundTransfer(long fromAccount, long toAccount, double amount) {
        if(repo.getBalance(fromAccount)>=amount){
            repo.updateBalance(fromAccount,repo.getBalance(fromAccount)-amount);
            repo.updateBalance(toAccount, repo.getBalance(toAccount)+amount);
            return true;
        }
        return false;
    }
}

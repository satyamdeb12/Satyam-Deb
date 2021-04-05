class BankAccount{
    constructor(accountNumber, accountHolderName, accountBalance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    
}

BankAccount.prototype.withdraw = function(amount){
    if(this.accountBalance>=amount){
        this.accountBalance = this.accountBalance-amount;
    }
}

class Savings extends BankAccount{
    constructor(accountNumber, accountHolderName, accountBalance,isSalary){
        super(accountNumber, accountHolderName, accountBalance);
        this.isSalary = isSalary;
    }
}


let s = new Savings(1,"vamsi",1000,true);
console.log(s.withdraw(100));


class Current extends BankAccount{
    constructor(accountNumber, accountHolderName, accountBalance,odLimit){
        super(accountNumber, accountHolderName, accountBalance);
        this.odLimit = odLimit;
    }
}

let c = new Current(2,"krishna",2000,100);
console.log(c.withdraw(200));
console.log(s.accountBalance);
console.log(c.accountBalance);
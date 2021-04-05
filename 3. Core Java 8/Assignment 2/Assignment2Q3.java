package Assignment2;

import java.util.ArrayList;

class CurrentAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int creditLimit = 2000;
    @Override
    public int getCash() {
    	return totalDeposits + creditLimit;
    }
}
class SavingsAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int fixedDepositAmount = 5000;
    @Override
    public int getCash() {
    	return totalDeposits + fixedDepositAmount;
    }
}
public class Assignment2Q3 {
    public int totalCashInBank(ArrayList<Integer> cash){
    	int total = 0;
    	for(Integer c : cash) {
    		total = total + c;
    	}
    	return total;
    }
    
    public int getCash(){
    	return 0;
    }
    public static void main(String[] args) {
    	Assignment2Q3 assignment2q3 = new Assignment2Q3();
    	CurrentAccount currentAccount = new CurrentAccount();
    	SavingsAccount savingsAccount = new SavingsAccount();
    	
    	ArrayList<Integer> cash = new ArrayList<Integer>();
    	cash.add(currentAccount.getCash());
    	cash.add(savingsAccount.getCash());
    	
    	System.out.println(assignment2q3.totalCashInBank(cash));
    }
}

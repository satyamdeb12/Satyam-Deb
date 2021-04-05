package Assignment1;

class SiCi {

    public double simpleInterest(double principalAmount,int time,double interestRate){

    	return (principalAmount*interestRate*time)/100;
    }
    
    public double compoundInterest(double principalAmount,int time,double interestRate){
    	double p = principalAmount;
    	int t = time;
    	double r = interestRate/100;
    	double interest = (p * Math.pow(1 + (r), t)) - p;

        return interest;
    }
}
public class Assignment1Q3 {
    public static void main (String args[]) {
    	
    	SiCi myInterest = new SiCi();
    	System.out.println(myInterest.simpleInterest(10000,5,7));
    	System.out.println(myInterest.compoundInterest(10000,5,7));
    }
}

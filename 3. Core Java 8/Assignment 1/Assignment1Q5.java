package Assignment1;

class TaxAmount{
    public double calculateTaxAmount(int ctc){
    	double taxPayable = 0;
    	if(ctc<=180000) {
    		taxPayable = 0;
    	}
    	else if(ctc >=180001 && ctc <= 300000){
    		taxPayable = ctc * 0.1;
    	}
    	else if(ctc>=300001 && ctc<=500000) {
    		taxPayable = ctc * 0.2;
    	}
    	else if(ctc>=500001 && ctc<=1000000) {
    		taxPayable = ctc * 0.3;
    	}
    	
    	return taxPayable;
    }
}
public class Assignment1Q5 {
    public static void main(String args[]) {
   
    	TaxAmount tax = new TaxAmount();
    	//0 - 180000 => 0%
    	System.out.println(tax.calculateTaxAmount(180000));
    	
    	//180001-300000 => 10%
    	System.out.println(tax.calculateTaxAmount(250000));
    	
    	//300001-500000 => 20%
    	System.out.println(tax.calculateTaxAmount(450000));

    	//500001-1000000 => 30%
    	System.out.println(tax.calculateTaxAmount(750000));
    	
    	
   }
}

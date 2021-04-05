package Assignment1;

import java.util.ArrayList;

class ArmstrongNumBetweenRange{
	public int[] armstrongNumbersInRange(int min , int max){
		
		int[] amstrongNumbers;
    	
    	ArrayList<Integer> tempList = new ArrayList<Integer>();
    	
    	for(int i = min+1; i<max; i++) {
    		int num = i, element=i, sum = 0;
    		
    		while(num>0) {
    			int digit = num%10;
    			sum = sum + digit*digit*digit;
    			num = num / 10;
    		}
    		if(element == sum) {
    			tempList.add(element);
    		}
    	}
    	
    	amstrongNumbers = new int[tempList.size()];
    	
    	for(int i = 0; i < tempList.size(); i++){
    		amstrongNumbers[i] = tempList.get(i);
    	}
    	return amstrongNumbers;
    }
}
public class Assignment1Q2 {

	public static void main(String[] args) {
		int min = 100;int max = 999;
	       ArmstrongNumBetweenRange getList = new ArmstrongNumBetweenRange();
	       
	       int[] list = getList.armstrongNumbersInRange(min, max);
	       
	       for(int i = 0; i < list.length; i++) {
	    	   System.out.print(list[i] + " ");
	       }
	}

}

package Assignment1;

import java.util.Scanner;

class ArmstrongOrNot {
	
	public int power(int num) {
		int p=0;
		
		while(num!=0) {
			++p;
			num=num/10;
		}
		
		return p;
	}
	
	public boolean armstrongCheck (int num){
		
		int p = power(num);
		int sum = 0;
		int number = num;
		
		while(num!=0) {
			int d = num%10;
			sum = (int) (sum+ Math.pow(d, p));
			num = num/10;
		}
		
		return sum==number;
	}
}

public class Assignment1Q1 {
	public static void main(String[] args) {
		int num;
		ArmstrongOrNot ob =new ArmstrongOrNot();
		Scanner sc= new Scanner(System.in);
		num=sc.nextInt();
		System.out.print(ob.armstrongCheck(num));
		sc.close();
	}
}

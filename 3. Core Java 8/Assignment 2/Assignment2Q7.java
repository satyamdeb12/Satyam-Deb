package Assignment2;

import java.util.Scanner;

abstract class DesertItem {
	static int existingCandy;
	static int existingCookie;
	static int existingIceCreams;
	abstract public int getCost();
}

class Candy extends DesertItem {

	public int addCandies(int candies) {
		existingCandy = existingCandy + candies;
		return existingCandy;
	}
	public int orderCandies(int num) {
		existingCandy = existingCandy - num;
		return existingCandy;
	}

	@Override
	public int getCost() {
		int candyCost = 60; // 1 candy = 1 dollar = Rupees 60
		return candyCost;
	}
}

class Cookie extends DesertItem {
	public int addCookies(int cookies) {
		existingCookie = existingCookie + cookies;
		return existingCookie;
	}
	public int orderCookies(int num) {
		existingCookie = existingCookie - num;
		return existingCookie;
	}

	@Override
	public int getCost() {
		int cookieCost = 70; // 1 cookie = 1 Euro = Rupees 70
		return cookieCost;
	}
}

class IceCream extends DesertItem {
	public int addIceCreams(int iceCreams) {
		existingIceCreams = existingIceCreams + iceCreams;
		return existingIceCreams;
	}
	public int orderIceCreams(int num) {
		existingIceCreams = existingIceCreams - num;
		return existingIceCreams;
	}

	@Override
	public int getCost() {
		int iceCreamCost = 1; // 1 iceCream = Rupees 1
		return iceCreamCost;
	}
}

public class Assignment2Q7 {
	public static void main(String[] args) {
		Assignment2Q7 assignment2q7 = new Assignment2Q7();
		assignment2q7.selectRoles();
		
		
	}

	private void selectRoles() {
		Candy candy = new Candy();
		Cookie cookie = new Cookie();
		IceCream iceCream = new IceCream();
		Scanner scanner = new Scanner(System.in);
		boolean state = true;
		
		
		while (state) {
			System.out.println("Enter 1 if you are an Owner and enter 2 if you are a Customer");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Welcome Owner\nSelect the Item you want to add:");
				System.out.println("Enter 1 to add Candies, 2 for Cookies and 3 for IceCreams");
				int ownerChoice = scanner.nextInt();
				switch (ownerChoice) {
				case 1:
					System.out.println("Enter the number of Candies you want to add");
					int numberOfCandies = scanner.nextInt();
					
					int totalCandies = candy.addCandies(numberOfCandies);
					System.out.println("Total " + totalCandies + " candies in stock");
					break;
				case 2:
					System.out.println("Enter the number of Cookies you want to add");
					int numberOfCookies = scanner.nextInt();
					
					int totalCookies = cookie.addCookies(numberOfCookies);
					System.out.println("Total " + totalCookies + " cookies in stock");
					break;
				case 3:
					System.out.println("Enter the number of Ice Creams you want to add");
					int numberOfIceCreams = scanner.nextInt();
					
					int totalIceCreams = iceCream.addIceCreams(numberOfIceCreams);
					System.out.println("Total " + totalIceCreams + " ice creams in stock");
					break;
				default:
					System.out.println("Please select a valid option");
					break;
				}
				break;
			case 2:
				System.out.println("Welcome CUstomer\nSelect item you want to order");
				System.out.println("Enter 1 to order Candies, 2 for Cookies and 3 for IceCreams");
				int customerChoice = scanner.nextInt();
				switch(customerChoice) {
				case 1:
					System.out.println("Enter the number of Candies you want to order");
					int orderCandies = scanner.nextInt();
					int totalCandies = candy.orderCandies(orderCandies);
					System.out.println("Total " + totalCandies + " candies in stock");
					break;
				case 2:
					System.out.println("Enter the number of Cookies you want to order");
					int orderCookies = scanner.nextInt();
					int totalCookies = cookie.orderCookies(orderCookies);
					System.out.println("Total " + totalCookies + " cookies in stock");
					break;
				case 3:
					System.out.println("Enter the number of IceCreams you want to order");
					int orderIceCreams = scanner.nextInt();
					int totalIceCreams = iceCream.orderIceCreams(orderIceCreams);
					System.out.println("Total " + totalIceCreams + " IceCreams in stock");
					break;
				default:
					System.out.println("Please select a valid option");
					break;
				}
				break;
			default:
				System.out.println("Enter a valid option.");
				break;
			}
		}
		scanner.close();
	}


}

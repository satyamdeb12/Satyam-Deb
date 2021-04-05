package Assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;




class Transaction {
	private Trader trader;
	private int year;
	private int value;
	
	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}

public class Assignment5Q4 {
	/*
	 * 1. Find all transactions in the year 2011 and sort them by value (small to high).
	 */
	public static List<Transaction> sortTransactions(List<Transaction> transactions) {
		return transactions.stream()
                .filter(x-> x.getYear()==2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
	}

	
	/*
	 * 2. Print all transactions’ values from the traders living in Delhi.
	 */
	public static List<Integer> transactionsValuesDelhi(List<Transaction> transactions) {
		List<Integer> values = new ArrayList<>();

        transactions.stream()
                .filter(x-> x.getTrader().getCity().equals("Delhi"))
                .forEach(x-> values.add(x.getValue()));

        return values;
	}

	
	/*
	 * 3. What’s the highest value of all the transactions?
	 */
	public static int highestTransaction(List<Transaction> transactions) {
		return transactions.stream().max(Comparator.comparingInt(Transaction::getValue)).get().getValue();
	}

	
	/*
	 * 4. Find the transaction with the smallest value.
	 */
	public static int smallestTransaction(List<Transaction> transactions) {
		return transactions.stream().min(Comparator.comparingInt(Transaction::getValue)).get().getValue();
	}

	public static void main(String[] args) {
		Trader trader1 = new Trader("Rakesh Jhunjhunwala", "Delhi");
		Trader trader2 = new Trader("Radhakishan Damani", "Indore");
		Trader trader3 = new Trader("Raamdeo Agrawal", "Delhi");

		
		Transaction transaction1 = new Transaction(trader1, 2011, 5000);
		Transaction transaction2 = new Transaction(trader2, 2011, 6000);
		Transaction transaction3 = new Transaction(trader3, 2011, 3000);
		
		Transaction transaction4 = new Transaction(trader1, 2012, 10000);
		Transaction transaction5 = new Transaction(trader2, 2012, 8000);
		Transaction transaction6 = new Transaction(trader3, 2012, 9000);
		
		
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction1);
		transactions.add(transaction2);
		transactions.add(transaction3);
		transactions.add(transaction4);
		transactions.add(transaction5);
		transactions.add(transaction6);
		
		//Testing sortTransactions Method
		List<Transaction> sortedTransactions = new ArrayList<Transaction>();
		sortedTransactions = sortTransactions(transactions);
		for (Transaction transaction : sortedTransactions) {
			System.out.println(transaction.getValue());
		}
		System.out.println("-----------------------");
		
		//Testing transactionsValuesDelhi Method
		List<Integer> l = new ArrayList<Integer>();
		l = transactionsValuesDelhi(transactions);
		for (Integer integer : l) {
			System.out.println(integer);
		}
		System.out.println("-----------------------");
		//Testing highestTransaction Method
		System.out.println(highestTransaction(transactions));
		System.out.println("-----------------------");
		
		//Testing smallestTransaction Method
		System.out.println(smallestTransaction(transactions));
		
	}
}

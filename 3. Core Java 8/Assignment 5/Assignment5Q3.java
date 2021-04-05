package Assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Trader {
	private String name;
	private String city;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	
}

public class Assignment5Q3 {
	
	/*
	 * 1. What are all the unique cities where the traders work?
	 */
	public static List<String> printUniqueCities(List<Trader> traders) {
		List<String> cities = new ArrayList<>();

        traders.forEach(x-> cities.add(x.getCity()));

        return cities.stream().distinct().collect(Collectors.toList());

	}

	
	/*
	 * 2. Find all traders from Pune and sort them by name.
	 */
	public static List<String> tradersFromPuneSortByName(List<Trader> traders) {
		List<String> l = new ArrayList<>();
        traders.stream()
                .filter(x-> x.getCity().equals("Pune"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(x-> l.add(x.getName()));

        return l;
	}

	
	/*
	 * 3. Return a string of all traders’ names sorted alphabetically.
	 */
	public static String allTradersNames(List<Trader> traders) {
		StringBuilder names = new StringBuilder();

        traders.stream().
                sorted(Comparator.comparing(Trader::getName))
                .forEach(x-> names.append(x.getName()));

        return names.toString();
	}

	/*
	 * 4. Are any traders based in Indore?
	 */
	public static ArrayList<Trader> areAnyTradersFromIndore(ArrayList<Trader> traders) {
		return (ArrayList<Trader>) traders.stream()
                .filter(x->x.getCity().equals("Indore"))
                .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Trader t1 = new Trader("Rakesh Jhunjhunwala", "Indore");
		Trader t2 = new Trader("Radhakishan Damani", "Indore");
		Trader t3 = new Trader("Raamdeo Agrawal", "Pune");
		Trader t4 = new Trader("Nemish Shah", "Pune");
		Trader t5 = new Trader("Vijay Kedia", "Mumbai");
		
		ArrayList<Trader> traders = new ArrayList<Trader>();
		traders.add(t1);
		traders.add(t2);
		traders.add(t3);
		traders.add(t4);
		traders.add(t5);
		
		
		//--------------------Testing printUniqueCities Method-----------------
		List<String> cities = new ArrayList<String>();
		cities = printUniqueCities(traders);
		for (String string : cities) {
			System.out.println(string);
		}
		System.out.println("-------------------------");
		//--------------------Testing tradersFromPuneSortByName Method---------
		List<String> listOfTradersFromPune = new ArrayList<String>();
		listOfTradersFromPune = tradersFromPuneSortByName(traders);
		for (String string : listOfTradersFromPune) {
			System.out.println(string);
		}
		System.out.println("-------------------------");
		//--------------------Testing allTradersNames--------------------------
		System.out.println(allTradersNames(traders));
		System.out.println("-------------------------");
		//--------------------Testing areAnyTradersFromIndore Method-----------
		ArrayList<Trader> allTraders = new ArrayList<Trader>();
		allTraders = areAnyTradersFromIndore(traders);
		for (Trader t : allTraders) {
			System.out.println(t.getName());
		}
	}
}

package Assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Fruit {
	private String name;
	private int calories;
	private int price;
	private String color;

	public Fruit(String name, int calories, int price, String color) {
		super();
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}

public class Assignment5Q1 {

	/*
	 * 1. Display the fruit names of low calories fruits i.e. calories < 100 sorted
	 * in descending order of calories.
	 */
	public static List<String> reverseSort(ArrayList<Fruit> fruits) {

		List<String> f = new ArrayList<>();

		fruits.stream().filter(x -> x.getCalories() < 100)
				.sorted(Comparator.comparingInt(Fruit::getCalories).reversed()).collect(Collectors.toList())
				.forEach(x -> f.add(x.getName()));

		return f;
	}

	// -----------------------------------------------------------------------------

	/*
	 * 2. Display color wise list of fruit names.
	 */
	public static ArrayList<Fruit> sort(ArrayList<Fruit> Fruits) {

        Fruits = (ArrayList<Fruit>) Fruits.stream().sorted(Comparator.comparing(Fruit::getColor))
                .collect(Collectors.toList());
       
        return Fruits;
    }

	// -----------------------------------------------------------------------------

	/*
	 * 3. Display only RED color fruits sorted as per their price in ascending
	 * order.
	 */
	public static ArrayList<Fruit> filterRedSortPrice(ArrayList<Fruit> fruits){
        fruits = (ArrayList<Fruit>) fruits.stream().filter(x-> x.getColor().equals("RED"))
                .sorted(Comparator.comparingInt(Fruit::getPrice))
                .collect(Collectors.toList());
        return fruits;
    }

	// -----------------------------------------------------------------------------

	public static void main(String[] args) {
		Fruit f1 = new Fruit("Apple", 95, 100, "RED");
		Fruit f2 = new Fruit("StrawBerry", 207, 180, "RED");
		Fruit f3 = new Fruit("Tomatoes", 89, 25, "RED");
		Fruit f4 = new Fruit("Banana", 111, 10, "Yellow");
		Fruit f5 = new Fruit("Grapes", 104, 6, "Green");
		Fruit f6 = new Fruit("Guava", 37, 120, "Blue");
		Fruit f7 = new Fruit("Jackfruit", 143, 20, "Sky");
		Fruit f8 = new Fruit("Mango", 202, 50, "Pink");

		ArrayList<Fruit> fruits = new ArrayList<>();
		fruits.add(f1);
		fruits.add(f2);
		fruits.add(f3);
		fruits.add(f4);
		fruits.add(f5);
		fruits.add(f6);
		fruits.add(f7);
		fruits.add(f8);
		// --------------------------Testing reverseSort Method----------------
		List<String> sorted = new ArrayList<String>();
		sorted = reverseSort(fruits);
		for (String string : sorted) {
			System.out.println(string);
		}
		System.out.println("--------------------------");
		// --------------------------Testing sort Method-----------------------
		ArrayList<Fruit> colorWiseList = new ArrayList<>();
		colorWiseList = sort(fruits);
		for (Fruit aFruit : colorWiseList) {
			System.out.println(aFruit.getName());
		}
		System.out.println("--------------------------");

		// --------------------------Testing filterRedSortPrice Method---------
		ArrayList<Fruit> redSortedOnPrice = new ArrayList<>();
		redSortedOnPrice = filterRedSortPrice(fruits);
		for (Fruit anotherFruit : redSortedOnPrice) {
			System.out.println(anotherFruit.getName());
		}
		System.out.println("--------------------------");
	}

}

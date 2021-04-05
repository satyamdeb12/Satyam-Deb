package Assignment2;

abstract class Car{
	abstract String start();
}
abstract class Tata extends Car{

	
	abstract String start();
	
	//Because of this abstract method, the Tata class has to be an abstract class
	//When an abstract class is subclassed, the subclass usually provides 
	//implementations for all of the abstract methods in its parent class.
	//However, if it does not, then the subclass must also be declared abstract.
	abstract String tataBrandLogo();
	
}
class Nano extends Tata{

	@Override
	String start() {
		
		return "Start Nano Car";
	}

	@Override
	String tataBrandLogo() {
		
		return "TATA NANO";
	}

	
	
}

public class Assignment2Q4 {

	public static void main(String[] args) {
		//The following line creates an error as we cannot instantiate abstract class.
		//Car car = new Car();
		
		Nano nano = new Nano();
		System.out.println(nano.start());
		System.out.println(nano.tataBrandLogo());
		
	}

}

package Assignment2;

class SingletonInheritanceCheck{
	private static SingletonInheritanceCheck singletonInstance = null;
	public int n;
	
	private SingletonInheritanceCheck() {
		n = 100;
	}
	public static SingletonInheritanceCheck getInstance() {
		if(singletonInstance == null) {
			singletonInstance = new SingletonInheritanceCheck();
		}
		return singletonInstance;
	}
}

public class Assignment2Q1 {
	
	public static void main(String[] args) {
		//instantiating the Singleton class with obj1
		SingletonInheritanceCheck obj1 = SingletonInheritanceCheck.getInstance();
		//instantiating the Singleton class with obj1
		SingletonInheritanceCheck obj2 = SingletonInheritanceCheck.getInstance();
		
		//Setting the value of n using obj1
		obj1.n = 200;
		
		//This is normal because we just set the value of n for obj1 in the previous line
		System.out.println(obj1.n);
		
		//Here we can see that the value of n for obj2 is also 200
		//This happened because only one instance of the singleton class was created 
		//obj1 and obj2 acts as a single instance
		System.out.println(obj2.n);
		
		obj2.n = 300;
		System.out.println(obj1.n);
		System.out.println(obj2.n);
	}
}

package Assignment2;

import java.util.ArrayList;

class Manager extends Assignment2Q2 {
    @Override
    public int getSalary(int salary) {
        int incentive = 5000;
        return salary+incentive;
    }
}

class Labour extends Assignment2Q2 {
    @Override
    public int getSalary(int salary) {
        int overtime = 500;
        return salary+overtime;
    }
}

public class Assignment2Q2 {
	
    public int getSalary(int salary){
    	return salary;
    }
    
    public int totalEmployeesSalary(ArrayList<Integer> employeeSalaries){
    	int totalSalary = 0;
    	
    	for(Integer employeeSalary : employeeSalaries) {
    		totalSalary = totalSalary + employeeSalary;
    	}
    	
    	return totalSalary;
    }
    public static void main(String[] args) {
    	Assignment2Q2 assignment2q2 = new Assignment2Q2();
    	Manager manager = new Manager();
    	Labour labour = new Labour();
    	
    	ArrayList<Integer> employeeSalaries = new ArrayList();
    	employeeSalaries.add(manager.getSalary(2000));
    	employeeSalaries.add(labour.getSalary(200));
    	
    	System.out.println(assignment2q2.totalEmployeesSalary(employeeSalaries));
    }
}
package org.example.main;

import java.util.ArrayList;

abstract class Employee{
	
	private String name;
	private int id;
	
	public Employee(String name,int id) {
		this.name=name;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public abstract double calculateSalary();
	
	@Override
	public String toString() {
		
		return "Employee[ name=" +name+ ", id=" +id+ ", salary=" +calculateSalary() +"]";
	}
	
}

class FullTimeEmployee extends Employee{
	
	private double monthlySalary;
	
	public FullTimeEmployee(String name,int id, double monthlySalary) {
	   
		super(name,id);
		this.monthlySalary=monthlySalary;
	
	}
	
	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee{

	private int hoursWorked;
	
	private double hourlyRate;
	
	public PartTimeEmployee(String name,int id, int hoursWorked,  double hourlyRate) {
		
		super(name,id);
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
		
		
	}
	
	
	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return hoursWorked*hourlyRate;
	}
	
	
}

class PayrollSystem{
	
	private ArrayList<Employee> emplist;
	
	public PayrollSystem() {
		
		emplist=new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		emplist.add(employee);
	}
	
	public void removeEmployee(int id) {
		
		Employee employeeToRemove =null;
		for(Employee employee:emplist) {
			
			if(employee.getId()==id) {
				employeeToRemove=employee;
				break;
			}
		}
		if(employeeToRemove!=null)
		{
			emplist.remove(employeeToRemove);
		}
		
	}
	
	public void displayEmployees() {
		
		for(Employee employee:emplist) {
			
			System.out.println(employee);			
		}
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		PayrollSystem prs=new PayrollSystem();
		
		FullTimeEmployee emp1=new FullTimeEmployee("Nilesh", 111, 1200000.00d);
		
		PartTimeEmployee emp2=new PartTimeEmployee("Parag", 222, 48, 100);
		
		prs.addEmployee(emp1);
		prs.addEmployee(emp2);
		
		System.out.println("Initial Employee Details : ");
		
		prs.displayEmployees();
		
		System.out.println("Removing Employees ");
		
		prs.removeEmployee(222);
		
		System.out.println("Remaining Employees Details  : ");
		
		prs.displayEmployees();
		

	}

}

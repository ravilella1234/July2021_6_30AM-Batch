package com.icici.loans.eduloans;

public class EmployeeChild extends Employee
{
	String city;
	
	public EmployeeChild(String city) 
	{
		super(1744,"ravilella",12.34f);
		this.city = city;
		System.out.println(this.city);
	}
	
	
	public static void main(String[] args)
	{
		EmployeeChild e = new EmployeeChild("hyderabd");
	}

}

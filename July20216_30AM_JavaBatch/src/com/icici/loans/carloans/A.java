package com.icici.loans.carloans;

import java.util.Date;

public  class A 
{	
	public  int x =100;
	public static final String cname = "vmware";
	
	public  void m1()
	{
		System.out.println("iam m1 from A");
		System.out.println(x);
		
	}
	
		
	public static void m3()
	{
		System.out.println("iam m3 static");
	}
	
	static
	{
		System.out.println("iam static block...");
	}
	
	static
	{
		Date dt = new Date();
		System.out.println(dt);
	}
	
	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
		A.m3();
	}

}

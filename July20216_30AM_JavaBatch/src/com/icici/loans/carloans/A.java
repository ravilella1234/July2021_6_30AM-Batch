package com.icici.loans.carloans;

public final class A 
{
	public int x = 100;
	
	public void m1()
	{
		System.out.println("iam m1 from A");
	}
	
	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
		System.out.println(a.x);
	}

}

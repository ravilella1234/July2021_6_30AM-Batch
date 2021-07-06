package com.icici.loans.eduloans;

import com.icici.loans.carloans.A;

public class C extends A
{
	public void m3()
	{
		System.out.println("iam m3 from C");
	}

	public static void main(String[] args) 
	{
		A a  = new A();
		a.m1();
		System.out.println(a.x);
		
		C c = new C();
		c.m1();
		c.m3();
		System.out.println( c.x);
	}

}

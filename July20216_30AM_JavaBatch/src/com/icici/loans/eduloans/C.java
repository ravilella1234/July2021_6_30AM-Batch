package com.icici.loans.eduloans;

import com.icici.loans.carloans.A;
import com.icici.loans.carloans.B;

public class C extends A
{
	public void m3()
	{
		System.out.println("iam m3 from C");
	}

	public static void main(String[] args) 
	{
		B b = new B();
		b.m1();
		b.m2();
		
		C c = new C();
		c.m1();
		c.m3();
	}

}
